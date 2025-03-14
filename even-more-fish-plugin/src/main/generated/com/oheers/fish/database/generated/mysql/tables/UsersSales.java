/*
 * This file is generated by jOOQ.
 */
package com.oheers.fish.database.generated.mysql.tables;


import com.oheers.fish.database.generated.mysql.DefaultSchema;
import com.oheers.fish.database.generated.mysql.Keys;
import com.oheers.fish.database.generated.mysql.tables.records.UsersSalesRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import java.util.Collection;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsersSales extends TableImpl<UsersSalesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>${table.prefix}users_sales</code>
     */
    public static final UsersSales USERS_SALES = new UsersSales();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UsersSalesRecord> getRecordType() {
        return UsersSalesRecord.class;
    }

    /**
     * The column <code>${table.prefix}users_sales.ID</code>.
     */
    public final TableField<UsersSalesRecord, Integer> ID = createField(DSL.name("ID"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>${table.prefix}users_sales.TRANSACTION_ID</code>.
     */
    public final TableField<UsersSalesRecord, String> TRANSACTION_ID = createField(DSL.name("TRANSACTION_ID"), SQLDataType.VARCHAR(22).nullable(false), this, "");

    /**
     * The column <code>${table.prefix}users_sales.FISH_NAME</code>.
     */
    public final TableField<UsersSalesRecord, String> FISH_NAME = createField(DSL.name("FISH_NAME"), SQLDataType.VARCHAR(256).nullable(false), this, "");

    /**
     * The column <code>${table.prefix}users_sales.FISH_RARITY</code>.
     */
    public final TableField<UsersSalesRecord, String> FISH_RARITY = createField(DSL.name("FISH_RARITY"), SQLDataType.VARCHAR(256).nullable(false), this, "");

    /**
     * The column <code>${table.prefix}users_sales.FISH_AMOUNT</code>.
     */
    public final TableField<UsersSalesRecord, Integer> FISH_AMOUNT = createField(DSL.name("FISH_AMOUNT"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>${table.prefix}users_sales.FISH_LENGTH</code>.
     */
    public final TableField<UsersSalesRecord, Double> FISH_LENGTH = createField(DSL.name("FISH_LENGTH"), SQLDataType.DOUBLE.nullable(false), this, "");

    /**
     * The column <code>${table.prefix}users_sales.PRICE_SOLD</code>.
     */
    public final TableField<UsersSalesRecord, Double> PRICE_SOLD = createField(DSL.name("PRICE_SOLD"), SQLDataType.DOUBLE.nullable(false), this, "");

    private UsersSales(Name alias, Table<UsersSalesRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private UsersSales(Name alias, Table<UsersSalesRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>${table.prefix}users_sales</code> table reference
     */
    public UsersSales(String alias) {
        this(DSL.name(alias), USERS_SALES);
    }

    /**
     * Create an aliased <code>${table.prefix}users_sales</code> table reference
     */
    public UsersSales(Name alias) {
        this(alias, USERS_SALES);
    }

    /**
     * Create a <code>${table.prefix}users_sales</code> table reference
     */
    public UsersSales() {
        this(DSL.name("${table.prefix}users_sales"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<UsersSalesRecord, Integer> getIdentity() {
        return (Identity<UsersSalesRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<UsersSalesRecord> getPrimaryKey() {
        return Keys.FK_USERSSALES_TRANSACTION;
    }

    @Override
    public UsersSales as(String alias) {
        return new UsersSales(DSL.name(alias), this);
    }

    @Override
    public UsersSales as(Name alias) {
        return new UsersSales(alias, this);
    }

    @Override
    public UsersSales as(Table<?> alias) {
        return new UsersSales(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public UsersSales rename(String name) {
        return new UsersSales(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UsersSales rename(Name name) {
        return new UsersSales(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public UsersSales rename(Table<?> name) {
        return new UsersSales(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public UsersSales where(Condition condition) {
        return new UsersSales(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public UsersSales where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public UsersSales where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public UsersSales where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public UsersSales where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public UsersSales where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public UsersSales where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public UsersSales where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public UsersSales whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public UsersSales whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
