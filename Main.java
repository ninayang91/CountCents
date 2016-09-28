import java.util.ArrayList;
import java.util.Hashtable;

public class Main {
	
	public static void main(String[] args){
		//int[] temp=new int[50];
		//System.out.println(countDP(3,temp));
		//print(getPath(3,3));
		int count=countCents(63);
		System.out.println(count);
	}
	
// We have unlimited 1,5,10,21,25 cents, change n cents using the least number of coins
	public static int countCents(int n){
		//if(n<=0)return 0;
		if(n==1||n==5||n==10||n==21||n==25)return 1;
		int count=n;
		int[] coin={1,5,10,21,25};
		int i=0; int temp;
		for(int x=coin[i++];x<=n/2&&i<coin.length;x=coin[i]){
			temp=countCents(x)+countCents(n-x);
			if(temp<count)count=temp;
		}
		return count;
	}
	
	public static void countCoin(int[] coins, int difCoins, int maxChange, int[] coinUsed){
		coinUsed[0]=0;
		for(int cents=1;cents<=maxChange;cents++){
			int minCoins=cents;
			for(int j=1;j<difCoins;j++){//try all the coins
				if(coins[j]>cents){//coins[j] can't be used
					continue;
				}
				if(coinUsed[cents-coins[j]]+1<minCoins){//coins[i] cents-coins[j]
					minCoins=coinUsed[cents-coins[j]]+1;//choose this one
				}
			}
			coinUsed[cents]=minCoins;
		}
		
	}

}
