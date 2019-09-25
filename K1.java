import com.sun.jna.Structure;

@Structure.FieldOrder({
        "id",
        "bNormal"
})
public class K1 extends Structure {

    public int id;
    public byte bNormal;

    public K1(){
       setAlignType(1);// align 0-4
    }

}
