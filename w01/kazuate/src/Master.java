package w01.kazuate.src;

import java.util.Random;

public class Master {
    private int turn;
    private int target;
    private Player player;

    public Master() {
    }

    public Master(Player player) {
        this.setTarget();
        this.player = player;
        this.turn = 0;
    }
    

    public void addTurn() {
        this.turn++;
        if(turn==5){
            System.out.println("■残念ながら5回以内に答えを当てられなかったためあなたの負けです．");
            this.selectContinue();
        }
    }

    public void setTarget() {
        Random rand = new Random();
        this.target = rand.nextInt(100);
    }

    public void doOneTurn() {
        System.out.println("■数字を入力してください残り"+(5-this.turn)+"回");
        int input = this.player.userInput();
        if(input == this.target){
            System.out.println("■当たり");
            System.out.println("■おめでとうございますあなたの勝ちです．");
            this.selectContinue();
        }else{
            int difference = input - this.target;
            if(difference > 0){
                System.out.println("■あなたが入力した数字は目標より大きいです．");
            }else{
                System.out.println("■あなたが入力した数字は目標より小さいです．");
            }
            if(difference > 20 || difference < -20){
                System.out.println("■あなたが入力した数字は目標から20以上離れています．");
            }
        }
        this.addTurn();
    }

    private void endGame() {
        System.exit(1);
    }

    private void selectContinue(){
        System.out.println("■もう一度遊びますか?");
        System.out.println("■Yes:0 , No:1");
        int input = this.player.userInput();
        if(input != 0 && input != 1){
            System.out.println("■入力は0か1です．");
            this.selectContinue();
        }
        if(input == 0){
            this.turn = 0;
            this.setTarget();
            System.out.println("■では始めましょう．");
        }
        if(input == 1){
            System.out.println("■Thank you for playing");
            this.endGame();
        }
    }
}
