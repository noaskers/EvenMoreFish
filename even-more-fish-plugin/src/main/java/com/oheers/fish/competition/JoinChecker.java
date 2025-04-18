package com.oheers.fish.competition;

import com.oheers.fish.EvenMoreFish;
import com.oheers.fish.config.MainConfig;
import com.oheers.fish.database.DataManager;
import com.oheers.fish.database.model.FishReport;
import com.oheers.fish.database.model.UserReport;
import com.oheers.fish.messages.ConfigMessage;
import com.oheers.fish.messages.abstracted.EMFMessage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JoinChecker implements Listener {

    /**
     * Reads all the database information for the user specified.
     *
     * @param userUUID The user UUID having their data read.
     * @param userName the in-game username of the user having their data read.
     */
    public void databaseRegistration(@NotNull UUID userUUID, @NotNull String userName) {
        if (!MainConfig.getInstance().isDatabaseOnline()) {
            return;
        }


        EvenMoreFish.getScheduler().runTaskAsynchronously(() -> {
            List<FishReport> fishReports;


            if (EvenMoreFish.getInstance().getDatabase().hasUserLog(userUUID)) {
                fishReports = EvenMoreFish.getInstance().getDatabase().getFishReportsForPlayer(userUUID);
            } else {
                fishReports = new ArrayList<>();
                //todo, bug here, if user joins, but doesn't participate in any comp, and then leaves, we get to this point again.
                EvenMoreFish.dbVerbose(userName + " has joined for the first time, creating new data handle for them.");
            }


            UserReport userReport;

            userReport = EvenMoreFish.getInstance().getDatabase().readUserReport(userUUID);
            if (userReport == null) {
                EvenMoreFish.getInstance().getDatabase().createUser(userUUID);
                userReport = EvenMoreFish.getInstance().getDatabase().readUserReport(userUUID);
            }

            if (fishReports != null && userReport != null) {
                DataManager.getInstance().cacheUser(userUUID, userReport, fishReports);
            } else {
                EvenMoreFish.getInstance().getLogger().severe("Null value when fetching data for user (" + userName + "),\n" +
                        "UserReport: " + (userReport == null) +
                        ",\nFishReports: " + (fishReports != null && !fishReports.isEmpty()));
            }
        });

    }

    // Gives the player the active fishing bar if there's a fishing event cracking off
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Competition activeComp = Competition.getCurrentlyActive();
        if (activeComp != null) {
            activeComp.getStatusBar().addPlayer(event.getPlayer());
            if (activeComp.getStartMessage() != null) {
                EMFMessage competitionJoin = ConfigMessage.COMPETITION_JOIN.getMessage();
                competitionJoin.setCompetitionType(activeComp.getCompetitionType().getTypeVariable().getMessage());
                EvenMoreFish.getScheduler().runTaskLater(() -> competitionJoin.send(event.getPlayer()), 20L * 3);
            }
        }

        EvenMoreFish.getScheduler().runTaskAsynchronously(() -> databaseRegistration(event.getPlayer().getUniqueId(), event.getPlayer().getName()));
    }

    // Removes the player from the bar list if they leave the server
    @EventHandler
    public void onLeave(PlayerQuitEvent event) {

        Competition activeComp = Competition.getCurrentlyActive();
        if (activeComp != null) {
            activeComp.getStatusBar().removePlayer(event.getPlayer());
        }

        if (!MainConfig.getInstance().isDatabaseOnline()) {
            return;
        }


        EvenMoreFish.getScheduler().runTaskAsynchronously(() -> {
            UUID userUUID = event.getPlayer().getUniqueId();

            if (!EvenMoreFish.getInstance().getDatabase().hasUser(userUUID)) {
                EvenMoreFish.getInstance().getDatabase().createUser(userUUID);
            }

            List<FishReport> fishReports = DataManager.getInstance().getFishReportsIfExists(userUUID);
            if (fishReports != null) {
                EvenMoreFish.getInstance().getDatabase().writeFishReports(userUUID, fishReports);
            }

            UserReport userReport = DataManager.getInstance().getUserReportIfExists(userUUID);
            if (userReport != null) {
                EvenMoreFish.getInstance().getDatabase().writeUserReport(userUUID, userReport);
            }

            DataManager.getInstance().uncacheUser(userUUID);
        });
        
    }
}
