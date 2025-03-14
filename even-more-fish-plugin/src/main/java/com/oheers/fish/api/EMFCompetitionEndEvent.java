package com.oheers.fish.api;

import com.oheers.fish.competition.Competition;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class EMFCompetitionEndEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Competition competition;

    public EMFCompetitionEndEvent(@NotNull Competition competition) {
        this.competition = competition;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    /**
     * @return the Competition object that has been terminated
     */
    public @NotNull Competition getCompetition() {
        return this.competition;
    }
}
