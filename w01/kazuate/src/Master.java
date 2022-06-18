package w01.kazuate.src;

import java.util.Random;

//数当てゲームのマスター（ディーラー）のクラス
public class Master {
    private int turn;
    private int target;
    private Player player;

    public Master() {
    }

    //コンストラクタ，プレイヤーと目標の数字現在のターンの初期設定をする．
    public Master(Player player) {
        this.setTarget();
        this.player = player;
        this.turn = 0;
    }
    

    //数当てゲームを1ターン進めるサブルーチン，ターンオーバーによるゲームの終了処理もここで行う．
    public void addTurn() {
        this.turn++;
        if(turn==5){
            System.out.println("■残念ながら5回以内に答えを当てられなかったため,あなたの負けです．");
            System.out.println("■答えは"+this.target+"でした．");
            this.selectContinue();
        }
    }

    //0から99までの間でランダムに目標となる数字を設定する．
    public void setTarget() {
        Random rand = new Random();
        this.target = rand.nextInt(100);
    }

    //1ターンのゲームの動きを実行するサブルーチン入力を受け取り，目標までのヒントを表示し，ゲームクリアによる終了の判定も行う．
    public void doOneTurn() {
        System.out.println("■数字を入力してください.(残り"+(5-this.turn)+"回)");
        int input = this.player.userInput();
        if(input == this.target){
            System.out.println("■当たり");
            System.out.println("■おめでとうございます,あなたの勝ちです．");
            this.selectContinue();
        }else{
            int difference = input - this.target;
            System.out.println(difference+","+this.target+","+input);
            if(difference > 0){
                System.out.println("■あなたが入力した数字は目標より大きいです．");
            }else{
                System.out.println("■あなたが入力した数字は目標より小さいです．");
            }
            if(difference >= 20 || difference <= -20){
                System.out.println("■あなたが入力した数字は目標から20以上離れています．");
            }
        }
        this.addTurn();
    }


    //プログラムを終了するサブルーチン
    private void endGame() {
        System.exit(1);
    }


    //プレイヤーにゲームを終えるか続けるかの選択をさせるサブルーチン
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
