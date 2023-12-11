package mockedObjects;

import com.example.tddslutprojekt.Consumer;
import com.example.tddslutprojekt.Buffer;
import com.example.tddslutprojekt.Item;

public class MockConsumer implements Consumer {
    Buffer mockBuffer;

    public MockConsumer(Buffer mockBuffer) {
        this.mockBuffer = mockBuffer;
    }

    public Item removeFromBuffer() {
       return mockBuffer.remove();
    }

    @Override
    public void run() {
    }

    @Override
    public void stopRunning() {
    }
}
