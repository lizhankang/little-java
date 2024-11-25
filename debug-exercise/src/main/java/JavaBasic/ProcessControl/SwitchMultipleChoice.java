package JavaBasic.ProcessControl;

public class SwitchMultipleChoice {
    public static void main(String[] args) {
        String fruit = "apple";
        switch (fruit) {  // switch语句还可以使用枚举类型
            case "apple":  // case语句具有“穿透性”
                System.out.println("Selected apple");
                break;
            case "pear":
            case "mango":
                System.out.println("Selected pear or mango");
                break;
            default:
                System.out.println("No fruit selected");
                break;
        }
    }
}
