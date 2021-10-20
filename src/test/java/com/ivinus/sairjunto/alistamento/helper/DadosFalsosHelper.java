package com.ivinus.sairjunto.alistamento.helper;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class DadosFalsosHelper {
    private static final Locale PT_BR = new Locale("pt", "BR");
    private static final Faker FAKER = Faker.instance(PT_BR);
    private DadosFalsosHelper() {

    }

    public static LocalDate dataNoPassado() {
        return FAKER.date().past(3, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    public static LocalDate dataNoFuturo() {
        return FAKER.date().future(3, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    public static LocalDateTime dataHoraNoPassado() {
        return FAKER.date().past(3, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    public static LocalDateTime dataHoraNoFuturo() {
        return FAKER.date().future(3, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
