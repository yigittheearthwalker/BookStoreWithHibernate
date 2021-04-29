# BookStoreWithHibernate
 
 A reinterpretation of my previous exercise BookStoreWithJDBC
 
 It covers persist and get opertions for three entities that are inherited from one MappedSuperclass
 
 It also has a CustomIDGenerator util class that assign's an ID based on the type of the subclass using @GenericGenerator annotation. For the sequence stuff I got help from [vladmihalcea](https://github.com/vladmihalcea/high-performance-java-persistence/blob/master/core/src/test/java/com/vladmihalcea/book/hpjp/hibernate/identifier/StringSequenceIdentifier.java "Go to Code")
