import org.junit.Test;

public class Gen {
    @Test
    public void genLogin(){
        StringBuilder login = new StringBuilder();
        for (int i=0;i<(160-8);i++){
            login.append("a");

        }
        login.append("@mail.ru");
        System.out.println(login);
        System.out.println(login.length());
    }

}
