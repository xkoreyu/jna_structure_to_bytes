import com.sun.jna.Pointer;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@Slf4j
public class Byte2Structure {
    public static void main(String[]args){
        ByteBuffer bf = ByteBuffer.allocate(5);
        bf.order(ByteOrder.LITTLE_ENDIAN);
        bf.putInt(100);
        bf.put((byte)1);
        K1 k1 = new K1();
        k1.setAutoRead(true);
        k1.setAutoSynch(true);
        k1.setAutoWrite(true);
        Pointer p = k1.getPointer();
        p.write(0,bf.array(),0,5);
        log.info("v {}",p.getByte(4));
        log.info("v {}",p.getInt(0));
        k1.read();
        log.info("v {} {}",k1.id,k1.bNormal);
    }
}
