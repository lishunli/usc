spring对AOP的支持

Aspect默认情况下不用实现接口，但对于目标对象（UserManagerImpl.java），在默认情况下必须实现接口
如果没有实现接口必须引入CGLIB库

我们可以通过Advice中添加一个JoinPoint参数，这个值会由spring自动传入，从JoinPoint中可以取得
参数值、方法名等等