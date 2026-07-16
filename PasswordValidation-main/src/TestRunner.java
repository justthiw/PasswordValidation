// ดูโจทย์ วิธีทำใน README.md
// หน้าที่ของคุณ: ออกแบบ test เอง แล้วเติม check(...) ให้ครบทุก branch
public class TestRunner {

    static int pass = 0, fail = 0;

    static void check(String name, boolean ok) {
        if (ok) { pass++; System.out.println("  [PASS] " + name); }
        else    { fail++; System.out.println("  [FAIL] " + name); }
    }

    public static void main(String[] a) {
        boolean ea = false;
        assert ea = true;
        if (!ea) System.out.println("** คำเตือน: assertion ปิดอยู่ รันด้วย  java -ea TestRunner **");

        System.out.println("== Password Validation ==");

        // ตัวอย่าง assertion ปกติ (ตัวแทนกลุ่ม valid)
        check("'Abcdef12' valid", PasswordValidator.validate("Abcdef12"));

        // ตัวอย่างแพตเทิร์นทดสอบ "ต้อง throw" ด้วย try/catch
        boolean threw = false;
        try { PasswordValidator.validate(null); }
        catch (IllegalArgumentException e) { threw = true; }
        check("null -> throws IllegalArgumentException", threw);

        // TODO: R2 - boundary ความยาว (เช่น 7, 8, 20, 21)
        check( "pasword len = 8 " , PasswordValidator.validate("Abcde345")== true);
        check( "pasword len < 8 " , PasswordValidator.validate("Abcdef1")== false);
        check( "pasword len = 20 " , PasswordValidator.validate("Abcdefghijk24nopqrst")== true);
        check( "pasword len > 20 " , PasswordValidator.validate("Abcdefghijklmnop4387stuvwxyz")== false);

        // TODO: R3 - ไม่มีตัวพิมพ์ใหญ่ -> fals
        check( "pasword no upper" , PasswordValidator.validate("hdisowowk123")== false);

        // TODO: R4 - ไม่มีตัวพิมพ์เล็ก -> false
        check( "pasword no lower" , PasswordValidator.validate("HDISOWOWK123")== false);

        // TODO: R5 - ไม่มีตัวเลข -> false
        check( "pasword no digit" , PasswordValidator.validate("Hdisowowk")== false);
        
        // TODO: R6 - มีช่องว่าง -> false
        check( "pasword has space" , PasswordValidator.validate("Abc d d d12")== false);

        // TODO: R7 - มีอักขระพิเศษ -> false
        check( "pasword has special char" , PasswordValidator.validate("Abcdef@2!")== true);

        //TODO : R8 - ไม่พิมพ์อะไรมาเลย -> false
        check( "pasword is empty" , PasswordValidator.validate("        ")== false);

        // TODO: boundary อื่นๆ ที่คุณคิดว่าจำเป็น

        System.out.println("==================================");
        System.out.printf("PASS %d / FAIL %d%n", pass, fail);
        System.out.println("==================================");
        System.exit(fail == 0 ? 0 : 1);
    }
}
