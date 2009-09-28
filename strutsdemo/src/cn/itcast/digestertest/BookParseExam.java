package cn.itcast.digestertest;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.BeanPropertySetterRule;
import java.io.InputStream;
public class BookParseExam {
	public void parse(String filename) throws Exception {
		Digester digester = new Digester();
		/*当Digester解析到xml文档中"书架/书"元素时，创建一个Book实例对象并将其压入到Digester内部使用的堆栈中。*/
		//digester.addObjectCreate("书架/书", Book.class);
		digester.push(new Book());
		/*在Digester注册XML文档中的XML路径“书架/书/书名”所应用的处理规则，当Digester解析到xml文档中"书架/书/书名"元素时，将该元素中的文本内容赋给栈顶的Book实例对象的bookname属性。按同样的方式，对Book实例对象的author 和price 进行赋值*/
		digester.addBeanPropertySetter("书架/书/书名", "bookname");
		digester.addBeanPropertySetter("书架/书/作者", "author");
		digester.addBeanPropertySetter("书架/书/售价", "price");
		/*当Digester解析到xml文档中"书架/书/书名"元素的"单位"属性时，将该属性值赋给栈顶的Book实例对象的unit属性。*/
		digester.addSetProperties("书架/书/售价", "单位", "unit");
		InputStream input = this.getClass().getResourceAsStream(filename);
		//调用Digester.parse方法解析book.xml文档。
		Book book = (Book)digester.parse(input);
		input.close();
		System.out.println(book);
	}
	public static void main(String[] args) throws Exception{
		BookParseExam bookParse = new BookParseExam();
		bookParse.parse("/cn/itcast/digestertest/book.xml");
	}
}
