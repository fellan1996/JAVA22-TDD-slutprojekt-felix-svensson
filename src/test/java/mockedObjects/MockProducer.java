package mockedObjects;

import com.example.tddslutprojekt.Buffer;
import com.example.tddslutprojekt.Item;
import com.example.tddslutprojekt.Producer;

public class MockProducer implements Producer {

    Buffer mockBuffer;

    public MockProducer(Buffer mockBuffer) {
        this.mockBuffer = mockBuffer;
    }

    public Boolean addToBuffer(Item item) {
        return mockBuffer.add(item);
    }

    @Override
    public void run() {

    }
    @Override
    public void stopRunning() {

    }
}
