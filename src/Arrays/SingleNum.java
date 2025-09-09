package Arrays;

public class SingleNum {

    public static void main(String[] args) {
        int[] arr={1,1,2,2,3,3,8};
        int[] prices={7,6,4,1,5,6,2};
        System.out.println("Single Number : "+singleNum(arr));
        System.out.println("Maximum Profit by selling a stock : "+buyAndSell(prices));
    }


    public static int singleNum(int[] arr){
        int ans=0;
        for(int a: arr){
            ans^=a;
        }
        return ans;
    }

    //Another way is to create a Frequency array or HashMap and then check freq==1 then return that element


    /// Buy and Sell Stocks

    public static int buyAndSell(int[] prices){

        int buyPrice=Integer.MAX_VALUE;
        int maxProfit=0;

        for(int price:prices){
            if(buyPrice<price){
              maxProfit = Math.max(maxProfit,price-buyPrice);
            }else{
                buyPrice=price;
            }

        }
        return maxProfit;
    }



}
