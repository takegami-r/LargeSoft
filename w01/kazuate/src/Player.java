package w01.kazuate.src;


//数当てゲームのプレーヤーのクラス
public class Player {
    public Player(){

    }


    //数当てゲームの入力を行うサブルーチン，ルールの例外入力をはじく処理も行う．
    public int userInput() {
        int userinput = KeyBoard.inputNumber();
        if(userinput >= 100 || userinput < 10){
            System .out.println("■入力は10から99までですもう一度入力してください．");
            userinput = this.userInput();
        }
        return userinput;
    }

}
