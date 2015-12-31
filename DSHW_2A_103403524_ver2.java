import java.util.Scanner;
import java.util.Stack;
public class DSHW_2A_103403524_ver2 {
	public static void main(String args[]){
		
		System.out.println("Transform Infix to Postfix for you.");//轉給你
		System.out.println("Enter what you want to transform.");//你要轉什麼
		Scanner sentence=new Scanner(System.in);//來一個輸入的
		String s=sentence.next();//輸入囉
		System.out.println("Here is the process of transfom by infix to postfix");//結果來囉
		System.out.println("Input Buffer\t\tOperator Stack\t\tOutput String");//過程 stack有什麼 輸出
		InputBuffer(s);//帶函示囉
	}
	public static void InputBuffer(String sentence){
		Stack<Character> st=new Stack<Character>();//先來一個stack
		String currentsituation=sentence;//設一個多的string 也沒問什麼 
		char[] c=currentsituation.toCharArray();//字串轉字元陣列喔
		String a ="";//多設一個  之後用這個來append東西
		String b="";//跟上面一樣
		for(int i =0;i<c.length;i++){//來這個迴圈就是在說我用switch判斷一下現在這個字元是什麼
			switch(c[i]){
			case'('://好了如果是左括號我就把他壓到堆疊
			{
				st.push(c[i]);
				break;
			}
			case')':{//那如果你看到右括號了  我們就看看這堆疊最上面是不是左括號如果不是我就一直把他append到剛剛那個a字串
				while((char)st.peek()!='('){
					a+=st.pop();
				}
				st.pop();//如果找到左括好了我也順便把它pop掉  可是我不要夾到a字串  因為我不要看到他
				break;
			}
			case'+':
			case'-':
			case'*':
			case'/':	{//如果是加減乘除我們看一下他的優先度了  如果堆疊有東西我們比一下現在這個字元跟最上面那個那個優先度高  如果最上面高我就清倒a內

					while(!st.empty()&&priority(c[i])<=priority(st.peek())){
						a+=st.pop();
					}
					st.push(c[i]);//所以如果空了或是優先權現在最高了  我就把這個壓進去
				break;
			}
			default:
				st.push(c[i]);//預設一下   一般的字我們就直接壓  在append到a字串
				a+=st.pop();
		}
				for(int j = i+1;j<c.length;j++){//接下來要來寫一下輸出了   我們用j來把一現在還剩的append到字串
					b+=c[j];
					
				}
				System.out.printf("%-10s\t\t%-10s\t\t%-10s",b,st.toString(),a);//於是我們就把b（剩下的）,現在堆疊內的,還有輸出寫出來
				
				System.out.println("");//換行
				b="";//把b空掉可以在append一次
		}
			while(st.empty()==false){//如果字串還有東西  我全部印出來勝的
				a+=st.pop();
				System.out.println(a);
			}

		
		
		
	}
	public static int priority(char op){//優先權+-是一*/是二左括號是0
	switch(op){	
		case '+': 
		case '-': 
			{
				return 1;}
		case '*': 
		case '/': 
			{
				return 2;}
		
		case '(':{
			return 0;}

	}
	return op;
	
	
}}
