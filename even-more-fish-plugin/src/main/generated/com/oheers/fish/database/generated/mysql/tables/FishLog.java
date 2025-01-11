/*
 * This file is generated by jOOQ.
 */
package com.oheers.fish.database.generated.mysql.tables;


import com.oheers.fish.database.generated.mysql.DefaultSchema;
import com.oheers.fish.database.generated.mysql.Keys;
import com.oheers.fish.database.generated.mysql.tables.records.FishLogRecord;

import java.time.LocalDateTime;
import java.util.Collection;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Name;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FishLog extends TableImpl<FishLogRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>${table.prefix}fish_log</code>
     */
    public static final FishLog FISH_LOG = new FishLog();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FishLogRecord> getRecordType() {
        return FishLogRecord.class;
    }

    /**
     * The column <code>${table.prefix}fish_log.ID</code>.
     */
    public final TableField<FishLogRecord, Integer> ID = createField(DSL.name("ID"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>${table.prefix}fish_log.RARITY</code>.
     */
    public final TableField<FishLogRecord, String> RARITY = createField(DSL.name("RARITY"), SQLDataType.VARCHAR(128).nullable(false), this, "");

    /**
     * The column <code>${table.prefix}fish_log.FISH</code>.
     */
    public final TableField<FishLogRecord, String> FISH = createField(DSL.name("FISH"), SQLDataType.VARCHAR(128).nullable(false), this, "");

    /**
     * The column <code>${table.prefix}fish_log.QUANTITY</code>.
     */
    public final TableField<FishLogRecord, Integer> QUANTITY = createField(DSL.name("QUANTITY"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>${table.prefix}fish_log.FIRST_CATCH_TIME</code>.
     */
    public final TableField<FishLogRecord, LocalDateTime> FIRST_CATCH_TIME = createField(DSL.name("FIRST_CATCH_TIME"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "");

    /**
     * The column <code>${table.prefix}fish_log.LARGEST_LENGTH</code>.
     */
    public final TableField<FishLogRecord, Float> LARGEST_LENGTH = createField(DSL.name("LARGEST_LENGTH"), SQLDataType.REAL.nullable(false), this, "");

    private FishLog(Name alias, Table<FishLogRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private FishLog(Name alias, Table<FishLogRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>${table.prefix}fish_log</code> table reference
     */
    public FishLog(String alias) {
        this(DSL.name(alias), FISH_LOG);
    }

    /**
     * Create an aliased <code>${table.prefix}fish_log</code> table reference
     */
    public FishLog(Name alias) {
        this(alias, FISH_LOG);
    }

    /**
     * Create a <code>${table.prefix}fish_log</code> table reference
     */
    public FishLog() {
        this(DSL.name("${table.prefix}fish_log"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<FishLogRecord> getPrimaryKey() {
        return Keys.FK_FISHLOG_USER;
    }

    @Override
    public FishLog as(String alias) {
        return new FishLog(DSL.name(alias), this);
    }

    @Override
    public FishLog as(Name alias) {
        return new FishLog(alias, this);
    }

    @Override
    public FishLog as(Table<?> alias) {
        return new FishLog(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public FishLog rename(String name) {
        return new FishLog(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public FishLog rename(Name name) {
        return new FishLog(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public FishLog rename(Table<?> name) {
        return new FishLog(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public FishLog where(Condition condition) {
        return new FishLog(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public FishLog where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public FishLog where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public FishLog where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public FishLog where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public FishLog where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public FishLog where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public FishLog where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public FishLog whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public FishLog whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
