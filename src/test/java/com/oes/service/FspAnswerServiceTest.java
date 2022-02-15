package com.oes.service;

import com.oes.model.FspAnswer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class FspAnswerServiceTest {

    @Resource
    FspAnswerService fspAnswerService;

    @Test
    public void findById() {
        System.out.println(fspAnswerService.findById(""));
    }

    @Test
    public void findAnswerStr() {
        FspAnswer fspAnswer=new FspAnswer();
        fspAnswer.setExamNo("SCGS18100703");
        fspAnswer.setUserId("2");
        fspAnswer.setFspId("2");
        System.out.println(fspAnswerService.findAnswerStr(fspAnswer));
    }

    @Test
    public void findAnswer() {
        FspAnswer fspAnswer=new FspAnswer();
        fspAnswer.setExamNo("SCGS18100703");
        fspAnswer.setUserId("2");
        List<FspAnswer> answer = fspAnswerService.findAnswer(fspAnswer);
        for (FspAnswer fspAnswer1 : answer) {
            System.out.println(fspAnswer1);
        }
    }

    @Test
    public void update() {
        FspAnswer fspAnswer7=new FspAnswer("7","test","8","SCGS18100703","2",null,null,null);
        fspAnswerService.update(fspAnswer7);
    }

    @Test
    public void delete() {
        fspAnswerService.delete("7");
    }

    @Test
    public void save() {
//        FspAnswer fspAnswer1=new FspAnswer(null,"override（重写） <br>（1）方法名、参数、返回值相同。<br>（2）子类方法不能抛出比父类方法更多的异常(但子类方法可以不抛出异常)。  <br>（3）方法被定义为final不能被重写。 <br>（4）被覆盖的方法不能为private。<br>overload（重载） <br>（1）参数类型、个数、顺序至少有一个不相同。 <br>（2）不能重载只有返回值不同的方法名。 <br>（3）不能通过访问权限、返回类型、抛出的异常进行重载； <br>","1","SCGS18100703","2",null,null,null);
//        FspAnswer fspAnswer2=new FspAnswer(null,"首先说运行速度，或者说是执行速度，在这方面运行速度快慢为：StringBuilder > StringBuffer > String<br>String最慢的原因： <br>String为字符串常量，而StringBuilder和StringBuffer均为字符串变量，即String对象一旦创建之后该对象是不可更改的，但后两者的对象是变量，是可以更改的。<br>再来说线程安全<br>在线程安全上，StringBuilder是线程不安全的，而StringBuffer是线程安全的<br>如果一个StringBuffer对象在字符串缓冲区被多个线程使用时，StringBuffer中很多方法可以带有synchronized关键字，所以可以保证线程是安全的，但StringBuilder的方法则没有该关键字，所以不能保证线程安全，有可能会出现一些错误的操作。<br>","2","SCGS18100703","2",null,null,null);
//        FspAnswer fspAnswer3=new FspAnswer(null,"final—修饰符（关键字）如果一个类被声明为final，意味着它不能再派生出新的子类，不能作为父类被继承。因此一个类不能既被声明为 abstract的，又被声明为final的。将变量或方法声明为final，可以保证它们在使用中不被改变。被声明为final的变量必须在声明时给定初值，而在以后的引用中只能读取，不可修改。被声明为final的方法也同样只能使用，不能重载。 <br>finally—再异常处理时提供 finally 块来执行任何清除操作。如果抛出一个异常，那么相匹配的 catch 子句就会执行，然后控制就会进入 finally 块（如果有的话）。 <br>finalize—方法名。Java 技术允许使用 finalize() 方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。<br>","3","SCGS18100703","2",null,null,null);
//        FspAnswer fspAnswer4=new FspAnswer(null,"a)在abstract class 中可以有自己的数据成员，也可以有非abstract的成员方法，而在interface中，只能够有静态的不能被修改的数据成员，所有的成员方法都是abstract的。 <br>b)abstract class和interface所反映出的设计理念不同。<br>c)接口中的方法默认都是 public abstract的; 属性默认是public final static。<br>e) 不管是抽象类还是接口都可以实现多态性，开发设计中一般优先使用接口，其次才考虑抽象类和继承。<br>","4","SCGS18100703","2",null,null,null);
//        FspAnswer fspAnswer5=new FspAnswer(null,"public static String reverse3(String old) {<br>        String result = \"\";<br>        List<string> olds = Arrays.asList(old.split(\"\"));<br>        Collections.reverse(olds);<br>        for (String s : olds) {<br>            result += s;<br>        }<br>        return result;<br>    }<br>","7","SCGS18100703","2",null,null,null);
//        FspAnswer fspAnswer6=new FspAnswer(null,"import java.util.HashMap;<br>public class Exe2 {<br>  public static void main(String[] args) {<br>    HashMap map=new HashMap();<br>    map.put(“张三“,90);<br>    map.put(“李四“,83);<br>    System.out.println(“修改前的成绩：“);<br>    System.out.println(map);<br>    map.put(“李四“,100);<br>    System.out.println(“修改后的成绩：“);<br>    System.out.println(map);<br>  }<br>}<br>","8","SCGS18100703","2",null,null,null);
//        fspAnswerService.save(fspAnswer1);
//        fspAnswerService.save(fspAnswer2);
//        fspAnswerService.save(fspAnswer3);
//        fspAnswerService.save(fspAnswer4);
//        fspAnswerService.save(fspAnswer5);
//        fspAnswerService.save(fspAnswer6);
        FspAnswer fspAnswer7=new FspAnswer(null,"test","8","SCGS18100703","2",null,null,null);
        fspAnswerService.save(fspAnswer7);
    }
}
