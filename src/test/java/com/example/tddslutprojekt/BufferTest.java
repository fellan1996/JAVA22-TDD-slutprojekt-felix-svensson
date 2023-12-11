package com.example.tddslutprojekt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import mockedObjects.MockConsumer;
import mockedObjects.MockProducer;

class BufferTest {

    MockConsumer mockConsumer;
    MockProducer mockProducer;
    Buffer testBuffer;

    private void initMockBuffer3Items() {
        //Mock setup
        Item item1 = new Item("mock1");
        Item item2 = new Item("mock2");
        Item item3 = new Item("mock3");
        testBuffer = new Buffer();
        testBuffer.add(item1);
        testBuffer.add(item2);
        testBuffer.add(item3);
    }

    @Test
    @DisplayName("removeFromBuffer returns correct item by testing id")
    void removeFromBufferMethodReturnsCorrectItem() {
        initMockBuffer3Items();
        mockConsumer = new MockConsumer(testBuffer);
        assertEquals("mock1", mockConsumer.removeFromBuffer().toString());
    }
    @Test
    @DisplayName("removeFromBuffer returns correct item by testing item")
    void removeFromBufferMethodReturnsCorrectItem2() {
        Item item1 = new Item("mock1");
        Item item2 = new Item("mock1");
        testBuffer = new Buffer();
        testBuffer.add(item1);
        testBuffer.add(item2);
        mockConsumer = new MockConsumer(testBuffer);
        assertNotEquals(item2, mockConsumer.removeFromBuffer());
    }

    @Test
    @DisplayName("addToBuffer returns true when adding item to buffer")
    void addToBufferMethodReturnsTrue() {
        Item item1 = new Item("mock1");
        testBuffer = new Buffer();
        mockProducer = new MockProducer(testBuffer);
        assertTrue(mockProducer.addToBuffer(item1));
    }
    @Test
    @DisplayName("addToBuffer returns true when adding a null-value to buffer")
    void addToBufferMethodWithAnArgumentOfNullStillReturnsTrue() {
        testBuffer = new Buffer();
        mockProducer = new MockProducer(testBuffer);
        assertTrue(mockProducer.addToBuffer(null));
    }
    @Test
    @DisplayName("buffer is empty when initialized")
    void bufferIsEmptyWhenInitialized() {
        testBuffer = new Buffer();
        assertTrue(testBuffer.buffer.isEmpty());
    }

    //what happens when adding null to buffer?
    @Test
    @DisplayName("InterrutedException is thrown when buffer is empty and thread is interrupted")
    void testInterruptedExceptionWhenBufferIsEmpty() throws InterruptedException {
        testBuffer = new Buffer();
        mockConsumer = new MockConsumer(testBuffer);
        Thread thread = new Thread(() -> {
            assertThrows(InterruptedException.class, () -> {
                mockConsumer.removeFromBuffer();
            });
        });
        thread.start();
        thread.interrupt();

    }


}