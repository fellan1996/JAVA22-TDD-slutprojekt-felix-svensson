package com.example.tddslutprojekt;

import mockedObjects.MockConsumer;
import mockedObjects.MockProducer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    Buffer testBuffer;

    @Test
    @DisplayName("Adding item with an id of 'mock1' works correctly")
    void addingItemWithAnIdOfEmptyStringWorksCorrectly() {
        Item itemMock1 = new Item("");
        assertEquals("", itemMock1.toString());
    }
    @Test
    @DisplayName("Special characters in id works correctly")
    void addingItemWithAnIdWithSpecialCharactersWorksCorrectly() {
        Item itemMock1 = new Item("!felix@$");
        assertEquals("!felix@$", itemMock1.toString());
    }
    @Test
    @DisplayName("An id containing only numbers works correctly")
    void addingItemWithAnIdContainingOnlyNumbers() {
        Item itemMock1 = new Item("1234567890");
        assertEquals("1234567890", itemMock1.toString());
    }

    @Test
    @DisplayName("Adding an item with an id of null throws exception")
    void addingItemWithAnIdOfNullThrowsException() {
        assertThrows(NullPointerException.class, () -> {
            Item itemMock1 = new Item(null);
        });
    }

    @Test
    @DisplayName("Setting new id works correctly")
    void settingNewIdWorksCorrectly() {
        Item itemMock1 = new Item("mock1");
        itemMock1.setId("mock1NEW");
        assertEquals("mock1new", itemMock1.toString());
    }

}