package w01.kazuate.src;

//数当てゲームのメインクラスゲームの説明文の表示とプレイヤーとゲームの初期設定を行いゲームの-1ターンを回す
public class Main {
    public static void main(String[] args) {
        System.out.println("■数当てゲームをしましょう．10から99までの間で私が考えている数字を当ててみてください．");
        System.out.println("■一回数字を入力するごとに答えより大きいか小さいか教えます．");
        System.out.println("■入力が答えから20以上離れているときは20以上離れていると教えます．");
        System.out.println("■5回以内に答えを当てられたらあなたの勝ちです．");
        System.out.println("■では始めましょう．");
        Player player = new Player();
        Master master = new Master(player);
        while(true){
            master.doOneTurn();
        }
    }
}
