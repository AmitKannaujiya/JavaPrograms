package array;
import java.util.Stack;
public class OnlineStockSpannerLeetCode {
    private Stack<Item> stack = null;
    private int index =-1;
    public OnlineStockSpannerLeetCode() {
        this.stack = new Stack<>();
    }
    public static void main(String[] args) {
        OnlineStockSpannerLeetCode obj = new OnlineStockSpannerLeetCode();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));

    }

    public int next(int price) {
        this.index++;
        while(!this.stack.isEmpty() && this.stack.peek().value < price) {
            stack.pop();
        }
        if(this.stack.isEmpty()) {
            this.stack.push(new Item(this.index, price));
            return this.index + 1;
        } else {
            int index = this.index - this.stack.peek().index ;
            this.stack.push(new Item(this.index, price));
            return index;
        }
    }
    
}

class Item {
    int index;
    int value;
    public Item(int index, int value) {
        this.index = index;
        this.value = value;
    }
}