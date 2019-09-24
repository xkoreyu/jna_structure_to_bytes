import com.sun.jna.Pointer;

import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


@Slf4j
public class Structure2Byte {

    public static void main(String[]args){
        K1 k1 = new K1();
        k1.setAutoRead(true);
        k1.setAutoSynch(true);
        k1.setAutoWrite(true);
        Pointer p = k1.getPointer();
        k1.id=100;
        k1.bNormal=(byte)1;
        k1.write();
        ByteBuffer bf = ByteBuffer.allocate(5);
        bf.order(ByteOrder.LITTLE_ENDIAN);
        p.read(0,bf.array(),0,5);
        log.info("p {}",p.getByte(0));
        log.info("p {}",p.getInt(1));
        log.info(" v {}",bf.getInt());
        log.info("v {}",bf.get());
    }
}
