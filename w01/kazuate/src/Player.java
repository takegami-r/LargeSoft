package w01.kazuate.src;

public class Player {
    public Player(){

    }

    public int userInput() {
        int userinput = KeyBoard.inputNumber();
        if(userinput > 100 && userinput <0){
            System .out.println("■入力は0から99までですもう一度入力してください．");
            this.userInput();
        }

        return userinput;
    }

}
