package repository;

import model.Shows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShowsDaoTest {
    @BeforeEach
    public void insertingShow() {
        Shows shows = new Shows("WhatEver","Something what you do not expecting", 120, "full drama", "J.Small");

    }

    @Test()
    @DisplayName("SavingShow")
    public void checkCreateChow() {


    }
}
