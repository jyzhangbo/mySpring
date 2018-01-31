### bean的作用域

- 单例（Singleton）：在整个应用中，只创建bean的一个实例
- 原型（Prototype）：每次注入或者通过Spring应用上下文获取的时候，都会创建一个新的bean实例
- 会话（Session）：在Web应用中，为每个会话创建一个bean实例
- 请求（Rquest）：在Web应用中，为每个请求创建一个bean实例

其中单例是默认的作用域，如果选择其他的作用域，要是用@Scope注解，它可以与@Component或@Bean一起是用。

##### 设置原型作用域

> @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)

##### 设置会话作用域

> @Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode=ScopedProxyMode.INTERFACES)

value设置成了WebApplicationContext中的SCOPE_SESSION常量（它的值是session）。这会告诉Spring为Web应用中的每个会话创建一个实例。
@Scope同时还有一个proxyMode属性，它被设置成了ScopedProxyMode.INTERFACES。这个属性解决了将会话或请求作用域的bean注入到单例bean中所遇到的问题。
如果要创建的实例是一个具体的类的话，Spring就没有办法创建基于接口的代理了。此时，它必须使用CGLib来生成基于类的代理。所以，如果bean类型是具体类的话，
我们必须要将proxyMode属性设置为ScopedProxyMode.TARGET_CLASS,以此来表明要以生成目标类扩展的方式创建代理。