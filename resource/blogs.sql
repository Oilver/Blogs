/*
Navicat MySQL Data Transfer

Source Server         : new
Source Server Version : 50544
Source Host           : localhost:3306
Source Database       : blogs

Target Server Type    : MYSQL
Target Server Version : 50544
File Encoding         : 65001

Date: 2019-07-26 00:09:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `ID` char(40) NOT NULL,
  `CATEGORY_ID` char(40) NOT NULL,
  `INTRODUCTION` text COMMENT '简介',
  `CONTENT` text NOT NULL COMMENT '内容',
  `PICTURE` char(200) DEFAULT NULL,
  `TITLE` char(40) NOT NULL,
  `READ_NUMBER` int(11) NOT NULL,
  `LIKE_NUMBER` int(11) NOT NULL,
  `MESS_NUMBER` int(11) NOT NULL,
  `UPDATED_TIME` datetime NOT NULL,
  `UPDATED_USER` char(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('123', '8', '我希望我的爱情是这样的，相濡以沫，举案齐眉，平淡如水。我在岁月中找到他，依靠他，将我希望我的爱情是这样的，相濡以沫，举案齐眉，平淡如水。我在岁月中找到他，依靠他，将一生交付给他。做他的妻子，他孩子的母亲，为他做饭，洗衣服，缝一颗掉了的纽扣。然后，我们一起在时光中变老。', '从前，我不相信爱情，现在我相信。世界上唯一比被爱更幸福的，就是去爱；唯一比被爱更幸运的，就是在茫茫人海中，找到值得爱的人。作家杜拉斯说“爱之于我，不是肌肤之亲，不是一蔬一饭，它是一种不死的欲望，是疲惫生活中的英雄梦想。”\r\n\r\n可能我不懂得煽情，我学不会安慰别人，每次看到别人伤心，我总是生硬的问句怎么了，别想太多了。我学不会思念，即使很长时间没见，我也不会主动打电话发短信说句我好想你之类的话。每次想要为别人做什么的时候还总是态度强硬闹得不愉快，可这就是我的方式，如果爱我，请接受这样的我。\r\n\r\n若，能让你我一起走过，那么，我奢求是地老天荒的时候你仍然牵着我的手，然后慢慢的一起变老。在月下，我们一起听风切切的吟，听曲轻轻的扬。我想，生活中没有比这更醉人的浪漫。于是，我的世界里有了一个独特的你，你的世界里多了一个平凡的我。\r\n\r\n我们都不是没有原则的人。但一辈子那么长，总会遇到某些人、某些事，打破了自己毕生坚持的原则。总要过几年出乎意料的日子、有几度疲劳揪心的挣扎，才算真正递交了“阅历”的答卷。一生真正深刻的，其实也不过就是那几年。经历到最后会明白，把时间浪费在难忘的时间里，一点也不后悔。\r\n\r\n爱到浪漫，是刚开始。爱到痛苦，是要分手。爱到平淡，就该结婚。感情发展到不同时期，就要做不同事。没有一辈子的浪漫和甜蜜，真正能长伴你身边的，只是慢慢老去的熟悉。情浓时说的一切都不可信，情淡时的每一天才是真。\r\n\r\n只要我们真正相爱，哪怕只有一天，一个小时，我们就不应该再有一刀两断的日子。也许你会在将来不爱我，也许你要离开我，但是我永远对你负有责任，就是你的一切苦难就永远是我的。我觉得我爱了你了，从此以后，不管什么时候，我都不能对你无动于衷。', 'http://image.blogs.com/2c9127b9-e7e3-4fe7-8281-dca7cc2981c4.JPG', '我希望我的爱情是这样的', '539', '526', '14', '2018-03-31 13:43:01', '邓小辉');
INSERT INTO `article` VALUES ('39eaade0-db1b-4787-8daa-7f4ff2142fcd', '1', '本博文内容参考相关博客以及《Java编程思想》整理而成，如有侵权，请联系博主。\r\n\r\n转载请注明出处：http://www.cnblogs.com/BYRans/\r\n\r\nPDF版下载链接：《Java基础知识总结》。\r\n\r\n如果您想在此基础上做一些修改，请联系dingyu.sdu@gmail.com，我把word原版发给您。', '1，JDK：Java Development Kit，java的开发和运行环境，java的开发工具和jre。\r\n\r\n2，JRE：Java Runtime Environment，java程序的运行环境，java运行的所需的类库+JVM(java虚拟机)。\r\n\r\n3，配置环境变量：让java jdkin目录下的工具，可以在任意目录下运行，原因是，将该工具所在目录告诉了系统，当使用该工具时，由系统帮我们去找指定的目录。\r\n\r\n环境变量的配置：\r\n\r\n1）：永久配置方式：JAVA_HOME=%安装路径%Javajdk\r\n\r\n     path=%JAVA_HOME%in\r\n\r\n    2）：临时配置方式：set path=%path%;C:Program FilesJavajdkin\r\n\r\n特点：系统默认先去当前路径下找要执行的程序，如果没有，再去path中设置的路径下找。\r\n\r\nclasspath的配置:\r\n\r\n1）：永久配置方式：classpath=.;c:;e:\r\n\r\n    2）：临时配置方式：set classpath=.;c:;e:\r\n\r\n \r\n\r\n注意：在定义classpath环境变量时，需要注意的情况\r\n\r\n如果没有定义环境变量classpath，java启动jvm后，会在当前目录下查找要运行的类文件；\r\n\r\n如果指定了classpath，那么会在指定的目录下查找要运行的类文件。\r\n\r\n还会在当前目录找吗？两种情况：\r\n\r\n    \r\n\r\nCLASSPATH是什么？它的作用是什么？\r\n\r\n它是javac编译器的一个环境变量。它的作用与import、package关键字有关。当你写下improt java.util.*时，编译器面对import关键字时，就知道你要引入java.util这个package中的类；但是编译器如何知道你把这个package放在哪里了呢？所以你首先得告诉编译器这个package的所在位置；如何告诉它呢？就是设置CLASSPATH啦 :) 如果java.util这个package在c:/jdk/ 目录下，你得把c:/jdk/这个路径设置到CLASSPATH中去！当编译器面对import java.util.*这个语句时，它先会查找CLASSPATH所指定的目录，并检视子目录java/util是否存在，然后找出名称吻合的已编译文件（.class文件）。如果没有找到就会报错！CLASSPATH有点像c/c++编译器中的INCLUDE路径的设置哦，是不是？当c/c++编译器遇到include 这样的语句，它是如何运作的？哦，其实道理都差不多！搜索INCLUDE路径，检视文件！当你自己开发一个package时，然后想要用这个package中的类；自然，你也得把这个package所在的目录设置到CLASSPATH中去！CLASSPATH的设定，对JAVA的初学者而言是一件棘手的事。所以Sun让JAVA2的JDK更聪明一些。你会发现，在你安装之后，即使完全没有设定CLASSPATH，你仍然能够编译基本的JAVA程序，并且加以执行。\r\n\r\n \r\n\r\nPATH环境变量\r\n\r\nPATH环境变量。作用是指定命令搜索路径，在命令行下面执行命令如javac编译java程序时，它会到PATH变量所指定的路径中查找看是否能找到相应的命令程序。我们需要把jdk安装目录下的bin目录增加到现有的PATH变量中，bin目录中包含经常要用到的可执行文件如javac/java/javadoc等待，设置好PATH变量后，就可以在任何目录下执行javac/java等工具了。', 'http://image.blogs.com/438b201b-a959-4293-855f-c151920b09db.jpg', 'JAVA语言基础知识', '7', '15', '3', '2018-03-06 13:42:23', '邓小辉');
INSERT INTO `article` VALUES ('4211e4a7-0895-4a9a-81a6-f1ad2aeea9d4', '8', '人生若只如初见，何事秋风悲画扇。等闲变却故人心，却道故人心易变。骊山语罢清宵半，泪雨霖铃终不怨。何如薄幸锦衣郎，比翼连枝当日愿。', '烟花易冷，岁月扑朔。如美花眷终也难抵似水流年，渐渐逝去。指间的流离，埋葬了一世的思念。仰问茫茫苍天，谁为谁痴狂，谁又为谁而心醉、心碎？旌旗摇曳的青春，似李白“丢官弃爵，举杯邀月，千金散尽还复来”的放荡与豪爽。似唐伯虎“但愿老死花酒间，不愿鞠躬车马前”的不屑与不羁。亦或是似***“孩儿立志出乡关，学不成名誓不还”般的壮志酬言。皆因年少轻狂而空付笑谈。\r\n\r\n月将落，乌将啼。独倚窗棂，醉看孤月微光。指间青烟袅袅，眉间缕缕悲意，口中青烟微吐。宁静的夜晚，月下孤魂，褪却尘世的喧嚣，去寻找内心的一片宁静。落魄的文字，笔尖的惆怅，一纸忧伤，写不尽旧时的时光，湮灭不了世事的沧桑。笔转红尘他乡，一曲悠扬天籁箫筝，绵绵不绝在月中回荡。醉意渐浓，笑看红尘往事，伫立奈何桥头，回首凝望，用漠然的目光看待整个世界，细数着往昔的沧桑，若梦浮生，谁又为谁而黯然魂伤？\r\n\r\n晨雨骤歇，云霁初开。静心梳理破碎的思绪，驱赶无由地恍惚与懈怠，心中思念难以释怀。不羁的笑容背后暗藏着无数的伪装，年少的青春，独守残花落日，用一支凋零的玫瑰来祭奠曾经的过往，黯然心中的惆怅与哀伤。。。。。。。', 'http://image.blogs.com/873ba2a8-09fa-4ff4-b43b-49821fca82bb.jpg', '年少轻狂之黯然', '7', '30', '2', '2018-03-09 13:43:03', '邓小辉');
INSERT INTO `article` VALUES ('51ddf7f2-0d69-48ac-a517-8135be4ec60b', '2', '使用Spring Boot可以让我们快速创建一个基于Spring的项目，而让这个Spring项目跑起来我们只需要很少的配置就可以了。', 'Spring框架功能很强大，但是就算是一个很简单的项目，我们也要配置很多东西。因此就有了Spring Boot框架，它的作用很简单，就是帮我们自动配置。Spring Boot框架的核心就是自动配置，只要存在相应的jar包，Spring就帮我们自动配置。如果默认配置不能满足需求，我们还可以替换掉自动配置类，使用我们自己的配置。另外，Spring Boot还集成了嵌入式的Web服务器，系统监控等很多有用的功，让我们快速构建企业及应用程序。\r\n创建项目很简单。如果使用STS的话，新建Spring Starter项目即可。如果使用IDEA的话，新建Spring Initializer项目。如果不想使用IDE的话，从start.spring.io创建项目也可以。例如下面就是一个Spring Boot项目的build.gradle文件，是我用IDEA创建的项目。由于我是用了最新的快照版本，因此这里的仓库还多了两个Spring的快找仓库，可以直接无视。（因为1.5的稳定版中Thymeleaf的支持才到2，为了使用最新Thymeleaf3，只能使用最新的快照版。）\r\n\r\n我们可以看到Spring Boot和一般的项目差不多，只不过多应用了Spring Boot插件，它会让我们更方便的运行Spring。另外在项目中没有其他依赖的引用，只引用了Spring Boot Starter依赖，这些依赖会将可能会使用到的依赖帮我们引用。例如spring-boot-starter-test会引用JUnit、AssertJ等一些测试框架，我们不用再引用了。这极大地方便了我们的开发。而且这些依赖不需要指定具体版本，具体的版本由Spring帮我们决定。关于详细的Starter项目和具体jar包的版本号，参考13.5. Starters和F. Dependency versions。', 'http://image.blogs.com/c8cff7b4-73ef-4b04-b8b4-5423e9676c86.jpg', '初识Spring Boot框架', '4', '20', '4', '2018-03-09 13:43:03', '邓小辉');
INSERT INTO `article` VALUES ('88c775b5-6c88-4a7b-8df3-acd0dff4cfdf', '3', '全栈工程师，也叫全端工程师(同时具备前端和后台能力)，英文Full Stack developer。是指掌握多种技能，并能利用多种技能独立完成产品的人。', '一、全局性思维\r\n现代项目的开发，需要掌握多种技术。互联网项目，需要用到后端开发、前端开发、界面设计、产品设计、数据库、各种移动客户端、三屏兼容、restFul API设计和OAuth等等，比较前卫的项目，还会用到Single Page Application、Web Socket、HTML5/CSS3这些技术以及像第三方开发像微信公众号微博应用等等。\r\nWeb前端也远远不是从前的切个图用个jQuery上个AJAX兼容各种浏览器那么简单了。现代的Web前端，需要用到模块化开发、多屏兼容、MVC，各种复杂的交互与优化，甚至你需要用到Node.js来协助前端的开发。\r\n所以说一个现代化的项目，是一个非常复杂的构成，需要一个人来掌控全局，它不需要是各种技术的资深专家，但它需要熟悉到各种技术。对于一个团队特别是互联网企业来说，有一个全局性思维的人非常非常重要。 \r\n二、沟通成本\r\n项目越大，沟通成本越高，项目中的人力是1+1<2的，人越多效率越低。因为沟通是需要成本的，不同技术的人各说各话，前端和后端是一定会掐架的。每个人都会为自己的利益而战，毫不为已的人是不存在的。\r\n而全栈工程师的沟通成本几乎为零，因为各种技术都懂，胸有成竹，自己就全做了。即使是在团队协作中，与不同技术人员的沟通也会容易得多，让一个后端和一个前端去沟通，那完全是鸡同鸭讲，更不用说设计师与后端了。但如果有一个人懂产品懂设计懂前端懂后端，那沟通的结果显然不一样，因为他们讲的，彼此都能听得懂。\r\n三、创业公司\r\n对于创业公司来说，全栈工程师的价值是非常大的，创业公司不可能像大公司一样，各方面的人才都有。所以需要一个多面手，各种活都能一肩挑，独挡多面的万金油。对于创业公司，不可能说DBA前端后端客户端各种人才全都备齐了，很多工作请人又不饱和，不请人又没法做，外包又不放心质量，所以全栈工程师是省钱的一妙招。虽然说全栈工程师工资会比一般的工程师会高很多，但综合下来，成本会低很多。', 'http://image.blogs.com/3727402e-9935-4c8d-ac89-cf1142e8c86d.jpg', '什么是全栈工程师', '0', '4', '0', '2018-03-09 13:43:02', '邓小辉');
INSERT INTO `article` VALUES ('9bd72ac4-d403-43aa-aabd-7d5264d664ed', '4', '网络基础知识整理', 'IP地址是因特网上的每个网络节点在全球范围内的唯一标识符，对每个节点来说，IP地址是一个32位的二进制代码，如11111111111111111111111111111111。为了提高可读性，我们常常把32位IP地址中的每8位转换为对应的十进制，并在两个十进制数之间插入一个点，即255.255.255.255，这种记法就是常用的点分十进制记法。\r\n\r\n       IP地址的编址经历了三个历史阶段，分类的IP地址、子网的划分以及构成超网。\r\n\r\n1.1分类的IP地址\r\n\r\n       分类的IP地址中是将IP划分为几种固定的类，每一类地址都有两个固定长度的字段组成--网络号和主机号。网络号是标志网络节点所连接到的网络，主机号标志该节点。IP地址主要分为5大类，A类、B类和C类都是单播地址，即一对一通信，最常用。D类地址用于多播，即一对多通信。E类地址保留为以后用。', 'http://image.blogs.com/09b730da-8e11-40e8-aabf-f84b3df98b5d.jpg', '网络基础', '0', '100', '0', '2017-10-04 13:42:37', '邓小辉');
INSERT INTO `article` VALUES ('9e99a80e-be41-4203-a82c-17adf93e16d0', '5', '数据结构是计算机存储、组织数据的方式。数据结构是指相互之间存在一种或多种特定关系的数据元素的集合。通常情况下，精心选择的数据结构可以带来更高的运行或者存储效率。数据结构往往同高效的检索算法和索引技术有关。', 'Sartaj Sahni在他的《数据结构、算法与应用》一书中称：“数据结构是数据对象，以及存在于该对象的实例和组成实 例的数据元素之间的各种联系。这些联系可以通过定义相关的函数来给出。”他将数据对象（data object）定义为“一个数据对象是实例或值的集合”。\r\nClifford A.Shaffer在《数据结构与算法分析》一书中的定义是：“数据结构是ADT（抽象数据类型Abstract Data Type） 的物理实现。”\r\nRobert L.Kruse在《数据结构与程序设计》一书中，将一个数据结构的设计过程分成抽象层、数据结构层和实现层。其中，抽象层是指抽象数据类型层，它讨论数据的逻辑结构及其运算，数据结构层和实现层讨论一个数据结构的表示和在计算机内的存储细节以及运算的实现。\r\n数据结构具体指同一类数据元素中，各元素之间的相互关系，包括三个组成成分，数据的逻辑结构，数据的存储结构和数据运算结构。', 'http://image.blogs.com/5f5b98d3-fee0-4a53-a378-369393561d61.jpg', '数据结构', '0', '520', '0', '2017-10-17 13:43:04', '邓小辉');
INSERT INTO `article` VALUES ('a505f27f-b2c3-4871-8c11-970fa271df38', '6', 'Swagger是一个Restful风格接口的文档在线自动生成和测试的框架', '现在已经将项目在github上开源了，取名为swagger-ui-layer。 \r\n欢迎star,fork,commit，也可以随意修改成自己喜欢的UI风格\r\n\r\ngithub地址：https://github.com/caspar-chen/swagger-ui-layer \r\n码云地址：https://www.oschina.net/p/swagger-ui-layer\r\n\r\n要使用swagger-ui-layer很简单 \r\n只需要在pom.xml中加入引用就可以了.然后就可以直接查看效果了 \r\nswagger-ui-layer 的默认访问地址是： http://${host}:${port}/docs.html', 'http://image.blogs.com/e7f551a5-c6f2-46cc-a587-0b07f705c5ac.jpg', 'Swagger 自定义UI界面', '6', '14', '0', '2018-03-09 13:43:06', '邓小辉');
INSERT INTO `article` VALUES ('b3de44b5-95d4-42b1-bfef-b0c10dbf1027', '7', '每次写东西就算是重复的内容，我也需要对编程语言和相关技术进行重新思考，不仅字斟句酌更是力求至臻完美，所以请相信我分享的一定是更新的、更好的、更有益的东西，这些内容也诉说着一个职业程序员和培训师的思想、精神和情感。', '1、面向对象的特征有哪些方面？\r\n答：面向对象的特征主要有以下几个方面：\r\n- 抽象：抽象是将一类对象的共同特征总结出来构造类的过程，包括数据抽象和行为抽象两方面。抽象只关注对象有哪些属性和行为，并不关注这些行为的细节是什么。\r\n- 继承：继承是从已有类得到继承信息创建新类的过程。提供继承信息的类被称为父类（超类、基类）；得到继承信息的类被称为子类（派生类）。继承让变化中的软件系统有了一定的延续性，同时继承也是封装程序中可变因素的重要手段（如果不能理解请阅读阎宏博士的《Java与模式》或《设计模式精解》中关于桥梁模式的部分）。\r\n- 封装：通常认为封装是把数据和操作数据的方法绑定起来，对数据的访问只能通过已定义的接口。面向对象的本质就是将现实世界描绘成一系列完全自治、封闭的对象。我们在类中编写的方法就是对实现细节的一种封装；我们编写一个类就是对数据和数据操作的封装。可以说，封装就是隐藏一切可隐藏的东西，只向外界提供最简单的编程接口（可以想想普通洗衣机和全自动洗衣机的差别，明显全自动洗衣机封装更好因此操作起来更简单；我们现在使用的智能手机也是封装得足够好的，因为几个按键就搞定了所有的事情）。\r\n- 多态性：多态性是指允许不同子类型的对象对同一消息作出不同的响应。简单的说就是用同样的对象引用调用同样的方法但是做了不同的事情。多态性分为编译时的多态性和运行时的多态性。如果将对象的方法视为对象向外界提供的服务，那么运行时的多态性可以解释为：当A系统访问B系统提供的服务时，B系统有多种提供服务的方式，但一切对A系统来说都是透明的（就像电动剃须刀是A系统，它的供电系统是B系统，B系统可以使用电池供电或者用交流电，甚至还有可能是太阳能，A系统只会通过B类对象调用供电的方法，但并不知道供电系统的底层实现是什么，究竟通过何种方式获得了动力）。方法重载（overload）实现的是编译时的多态性（也称为前绑定），而方法重写（override）实现的是运行时的多态性（也称为后绑定）。运行时的多态是面向对象最精髓的东西，要实现多态需要做两件事：1). 方法重写（子类继承父类并重写父类中已有的或抽象的方法）；2). 对象造型（用父类型引用引用子类型对象，这样同样的引用调用同样的方法就会根据子类对象的不同而表现出不同的行为）。', 'http://image.blogs.com/7a51d52b-fcb0-47f0-8398-0474426d1a13.jpg', 'Java面试题', '0', '77', '0', '2018-03-14 13:45:02', '邓小辉');
INSERT INTO `article` VALUES ('string', '3', '测试增加文章——简介', '测试增加文章——内容', 'http://image.blogs.com/12345.jpg', '测试增加文章', '16', '0', '0', '2018-04-14 00:31:24', '邓小辉');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `ID` char(40) NOT NULL,
  `NAME` char(15) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '基础知识');
INSERT INTO `category` VALUES ('2', '技术框架');
INSERT INTO `category` VALUES ('3', '全栈开发');
INSERT INTO `category` VALUES ('4', '网络知识');
INSERT INTO `category` VALUES ('5', '数据结构');
INSERT INTO `category` VALUES ('6', '常用工具');
INSERT INTO `category` VALUES ('7', '后端面试');
INSERT INTO `category` VALUES ('8', '其他分类');

-- ----------------------------
-- Table structure for life_image
-- ----------------------------
DROP TABLE IF EXISTS `life_image`;
CREATE TABLE `life_image` (
  `ID` char(40) NOT NULL,
  `URL` char(255) NOT NULL,
  `SIZES` decimal(10,0) NOT NULL,
  `DATATIME` datetime NOT NULL,
  `TITLE` char(40) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of life_image
-- ----------------------------
INSERT INTO `life_image` VALUES ('0dcb3e7b-7c2c-450f-91be-2e34714857c9', 'http://lifeimage.blogs.com/b388a5a6-5e6d-4ecd-934c-54b0e6674da9.JPG', '2144543', '2018-05-09 17:06:04', 'test');
INSERT INTO `life_image` VALUES ('166c6736-f88e-4a8d-8c74-fc8d6fb0066c', 'http://lifeimage.blogs.com/1c4f3768-4a65-4033-96d6-bcd95a7c56f6.JPG', '247367', '2018-05-09 17:08:08', 'test');
INSERT INTO `life_image` VALUES ('27a913ce-7823-4cfe-977c-2b1cf499087f', 'http://lifeimage.blogs.com/d4391d8b-a3f5-4bd6-9a71-6d75d2d6dcb9.JPG', '72025', '2018-05-09 17:00:25', 'test');
INSERT INTO `life_image` VALUES ('3acbc729-4bfa-41e2-a542-355d47f3df71', 'http://lifeimage.blogs.com/9e1100eb-c7e3-4d0b-8992-5563eb4044f2.jpg', '187576', '2018-05-09 17:07:20', 'test');
INSERT INTO `life_image` VALUES ('6d039843-61b1-4107-b7c8-e847146621db', 'http://lifeimage.blogs.com/89d6a001-5dbb-4c56-b695-cbe000e2073a.JPG', '1127262', '2018-05-09 17:07:46', 'test');
INSERT INTO `life_image` VALUES ('b308457e-cc9f-447b-aaa9-15f9be1bca05', 'http://lifeimage.blogs.com/2e41fa12-d809-4d00-ac29-ccc6ee8ea87a.jpg', '661303', '2018-05-09 17:07:06', 'test');
INSERT INTO `life_image` VALUES ('cacd28d6-d77e-436d-8ae5-b25169a52ae7', 'http://lifeimage.blogs.com/44200b10-9907-4711-8a22-e5d1fccc0445.JPG', '124521', '2018-05-09 17:07:55', 'test');
INSERT INTO `life_image` VALUES ('f84c0ae5-1a4e-4005-b468-901c696a1f85', 'http://lifeimage.blogs.com/6848af5e-6e34-4f26-ad44-58a57d4ca69e.jpg', '1858442', '2018-05-09 17:06:35', 'test');
INSERT INTO `life_image` VALUES ('fb4c6914-14b1-427a-842d-41b8c3cd7d2a', 'http://lifeimage.blogs.com/101be3f5-2900-4e66-bb96-a8dcf1e3d842.bmp', '39573', '2018-05-09 16:59:07', 'test');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `ID` char(40) NOT NULL,
  `FLOOR` int(11) unsigned zerofill NOT NULL DEFAULT '00000000000',
  `ARTICLE_ID` char(40) NOT NULL,
  `CONTENT` text NOT NULL,
  `UPDATED_TIME` datetime NOT NULL,
  `UPDATED_USER` char(40) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('03529f8c-0057-4cd4-8180-11d12112e1a6', '00000000005', '123', 'string', '2018-03-09 17:20:34', 'test1');
INSERT INTO `message` VALUES ('066bbf7b-29dd-4c29-86de-8eb9144320c2', '00000000001', '000', 'string', '2018-03-09 17:20:49', 'test1');
INSERT INTO `message` VALUES ('1', '00000000001', '123', '23213', '2018-03-01 17:04:05', '213');
INSERT INTO `message` VALUES ('100f2e06-a210-4788-ba97-4046479f2dc5', '00000000002', 'string', '321', '2018-05-05 16:48:12', 'Oliver');
INSERT INTO `message` VALUES ('130a6a6c-e9a8-4003-8180-4304bb7a5c83', '00000000001', 'a505f27f-b2c3-4871-8c11-970fa271df38', '值得学习', '2018-05-07 11:29:19', 'test1');
INSERT INTO `message` VALUES ('1cb2d967-cf3d-4581-ac42-08655c831c05', '00000000004', 'string', 'string', '2018-05-09 10:37:54', 'string');
INSERT INTO `message` VALUES ('2', '00000000002', '123', '31231', '2018-03-06 17:05:35', '233');
INSERT INTO `message` VALUES ('260970ed-6f29-4dfe-bf49-e11424586969', '00000000004', '123', 'string', '2018-03-09 17:20:03', 'test1');
INSERT INTO `message` VALUES ('26e4b231-3706-46ea-a85f-6f83044803ff', '00000000002', '51ddf7f2-0d69-48ac-a517-8135be4ec60b', '测试2', '2018-04-13 23:28:55', 'test1');
INSERT INTO `message` VALUES ('2f2d13e6-9008-4328-8328-c508846937b5', '00000000001', '51ddf7f2-0d69-48ac-a517-8135be4ec60b', '测试1', '2018-04-13 23:28:48', 'test1');
INSERT INTO `message` VALUES ('304d7e0d-af1d-41cb-b513-344f77547880', '00000000003', '123', 'string', '2018-03-09 17:19:45', 'test1');
INSERT INTO `message` VALUES ('5671be29-72cc-40f7-9505-c1f1d0f9a5ab', '00000000003', '4211e4a7-0895-4a9a-81a6-f1ad2aeea9d4', '我觉得你说得对', '2018-05-09 10:49:52', 'test2 回复--1楼--test1');
INSERT INTO `message` VALUES ('6d78ef89-817b-436b-9bfe-9e50809acc82', '00000000011', '123', '你还是', '2018-05-07 12:28:24', 'test1');
INSERT INTO `message` VALUES ('6e0880d8-3425-4f07-8036-1b4c6eadfee0', '00000000010', '123', '我觉得你说得对！', '2018-04-13 21:41:13', 'Oliver 回复--9楼--string');
INSERT INTO `message` VALUES ('707f1fcd-d905-4279-94ec-8cd7971088df', '00000000007', '123', 'qqqqqqqqqq', '2018-03-29 23:05:11', 'string');
INSERT INTO `message` VALUES ('7157067f-3296-490c-8a8a-6d1468e8508d', '00000000001', '4211e4a7-0895-4a9a-81a6-f1ad2aeea9d4', '123', '2018-05-09 10:45:33', 'test1');
INSERT INTO `message` VALUES ('73e0a6e9-151d-4c67-ad59-7e8970f4ce57', '00000000001', 'string', '好看', '2018-05-05 10:09:07', 'Oliver');
INSERT INTO `message` VALUES ('8029be38-d443-4d5f-af40-35e9b8fd9b2c', '00000000004', '51ddf7f2-0d69-48ac-a517-8135be4ec60b', '我觉得你说的对！', '2018-04-13 23:34:07', 'Oliver 回复--1楼--test1');
INSERT INTO `message` VALUES ('827e712b-1351-4155-883d-db0595f256d6', '00000000009', '123', 'test123', '2018-04-13 16:39:52', 'string');
INSERT INTO `message` VALUES ('9612f471-8a48-4f72-a8d2-a4c96a76794a', '00000000008', '123', '你好！我觉得你说得对！', '2018-03-29 23:40:10', 'Oliver 回复--3楼--test1');
INSERT INTO `message` VALUES ('a1ac544d-fc4e-45e6-8512-c2c87d32e3a7', '00000000006', '123', 'testtest', '2018-03-28 10:34:11', 'test1');
INSERT INTO `message` VALUES ('b533edc5-0fab-46af-8223-a1d554ed6b7f', '00000000002', '12312312', '这篇文章真不错！', '2018-04-13 21:39:46', 'Oliver');
INSERT INTO `message` VALUES ('cf795195-bc76-40b5-a978-a5d9b0722d94', '00000000001', '12312312', 'asd', '2018-04-13 21:39:19', 'Oliver');
INSERT INTO `message` VALUES ('d807b104-b8f4-4957-b595-dd61fdb6738c', '00000000003', '51ddf7f2-0d69-48ac-a517-8135be4ec60b', '测试3', '2018-04-13 23:29:01', 'test1');
INSERT INTO `message` VALUES ('db87c58f-de85-4bb8-85a7-f0f3fde871fe', '00000000005', '51ddf7f2-0d69-48ac-a517-8135be4ec60b', '测试3', '2018-04-14 00:26:43', 'test1');
INSERT INTO `message` VALUES ('edc31fa5-e456-4ae1-a37e-041cf03c5e0c', '00000000002', '4211e4a7-0895-4a9a-81a6-f1ad2aeea9d4', '对', '2018-05-09 10:46:18', 'test2');
INSERT INTO `message` VALUES ('f219e31b-af42-427f-8c66-9b2a6e303ae9', '00000000003', 'string', 'string', '2018-05-09 10:37:47', 'string');
INSERT INTO `message` VALUES ('f82e2f7d-0f27-4963-b30f-9de006724bb9', '00000000006', '51ddf7f2-0d69-48ac-a517-8135be4ec60b', '测试3', '2018-04-14 00:29:02', 'test1');

-- ----------------------------
-- Table structure for recommend
-- ----------------------------
DROP TABLE IF EXISTS `recommend`;
CREATE TABLE `recommend` (
  `ID` char(40) NOT NULL,
  `SERIAL` int(2) NOT NULL,
  `TITLE` char(40) NOT NULL,
  `URL` char(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recommend
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` char(40) NOT NULL,
  `USERNAME` char(32) NOT NULL,
  `PASSWORD` char(32) NOT NULL,
  `PROFESSION` char(32) DEFAULT NULL,
  `PHONE` char(32) DEFAULT NULL,
  `EMAIL` char(32) DEFAULT NULL,
  `IS_ADMIN` int(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `index_user` (`USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0010024e-6e65-456c-8d61-2ed19f89ee5b', 'test3', '2D46DC8289B4A4F6D247D1DE6E845A72', '教师', '644747', '321@qq.com', '0');
INSERT INTO `user` VALUES ('73854b1b-09d8-4c0d-a7ec-ef7947aeaf64', 'test2', '38DB06568C28F078D2E3A52E1568082C', '工程师', '18828', 'test2@qq.com', '0');
INSERT INTO `user` VALUES ('d1f76f0e-700a-4278-93c8-87ba28e5cae8', 'test1', 'D0C94532E49CDF171B759F7BD568E086', '教练', '688547', 'test1@qq.com', '0');
INSERT INTO `user` VALUES ('ee745603-cbce-4235-b794-7682e743dae7', 'Oliver', '8C0CC0179D84B645F4647E62CCB7F78F', '计算机科学与技术', '18819258248', '543527507@qq.com', '1');
