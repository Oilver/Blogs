/**
 * Created by 辉 on 2018/3/6.
 */
// $(function () {
//     $('#toRegister').click(function () {
//         $('#login').hide()
//         $('#register').show()
//     })
//     $('#toLogin').click(function () {
//         $('#register').hide()
//         $('#login').show()
//     })
// })

var vm = new Vue({
    el:"#container",
    data(){
        return{
            user:{
                // 从sessionStorage里获取
                username:window.sessionStorage.username || '',
                profession:window.sessionStorage.profession || '',
                id:window.sessionStorage.id || '',
                email:window.sessionStorage.email || '',
                phone:window.sessionStorage.phone || '',
            },
            regUser:{
                regInputUserName:'',     // 注册的账户
                regInputPassword:'',     // 注册的密码
                regInputAgainPassword:'',     // 注册的再次输入密码
                regInputPhone:'',     // 注册的电话
                regInputEmail:'',     // 注册的邮箱
                regInputPro:''          // 注册的专业
            },
            loginUser:{
                inputUserName:'',       //  输入的账户
                inputPassword:'',       // 输入的密码
            },
            isIndex : true,         // 是不是在首页
            isList:false,           // 是不是在列表页
            isDetail:false,         // 是不是在详情页
            isClickMenu:false,         // 是否点击了用户菜单(注销)
            active:0,          // 控制菜单烂active类
            article:[],         // 获取文章数据
            detail:{},           // 获取文章详细页面
            currentTime:new Date(),   // 目前日期
            articleLimitValue:5,          // 每页面最多显示5条文章
            moreMessage:"...显示更多",
            remarkContent: null,            // 评论的内容
            messagedObject:null  // 要回复的用户
        }
    },
    mounted(){
        this.getData(this.active);
    },
    methods: {
        showList(categoryId) {
            // 改变菜单栏li的active类
            this.active =categoryId;
            // 首页banner 隐藏
            this.isIndex = false;
            this.isList = true;
            this.isDetail = false;
            //获取数据
            this.getData(categoryId);
            this.moreMessage = "...显示更多";
            this.articleLimitValue = 5;
        },
        getData(active) {
            // 首页
            if (active == 0) {
                this.$http.get("http://127.0.0.1:9091/article/article/index").then(response => {
                    // 获取到请求的 文章数据
                    this.article = response.body.data;
                }, response => {
                    console.log("error!");
                });
            } else {
                // 其他列表页
                // categoryId 参数
                const params = {"categoryId": "" + active};
                this.$http.get("http://127.0.0.1:9091/article/articleByCategory", {params: params}).then(response => {
                    // 获取到请求的 文章数据
                    this.article = response.body.data;
                }, response => {
                    console.log("error!");
                });
            }
        },
        showArticleDetails(id){
            this.isDetail = true;
            this.isList = false;
            this.isIndex = false;
            // 请求文章详情页
            // ID参数
            const params={"id":id}
            this.$http.get("http://127.0.0.1:9091/article/article",{params:params}).then(response=>{
                    // 获取文章详情页
                this.detail = response.body.data;
            },response=>{
                console.log("error!");
            });
        },
        limitArticleNum:function () {
            if ( this.moreMessage == "...显示更多"){
                this.articleLimitValue = this.article.length;
                this.moreMessage = "...隐藏部分";
            }else{
                this.articleLimitValue = 5;
                this.moreMessage = "...显示更多";
            }
        },
        likeArticle:function (item) {
            // 文章点赞
            const params={"id":item.id};
            this.$http.post("http://127.0.0.1:9091/article/likeArticle",params,{emulateJSON: true}).then(response=>{
                if (response.status == 200){
                    // 将传进来的文章的likeNumber设置为返回的data值
                    item.likeNumber = response.body.data;
                }
            },response=>{
                console.log("error!");
            });
        },
        loginModal:function (status) {
            // 登录模态框的显示
            var modal = document.getElementById('loginModal');
            if (status == 1) {
                modal.style.display = "block";
            }else{
                modal.style.display = "none";
            }
        },
        regModal:function (status) {
            // 注册模态框的显示
            var modal = document.getElementById('regModal');
            if (status == 1) {
                modal.style.display = "block";
            }else{
                modal.style.display = "none";
            }
        },
        login:function () {
            // 登录
            const params={"username":this.loginUser.inputUserName,"password":this.loginUser.inputPassword};
            this.$http.post("http://127.0.0.1:9091/customer/login",params).then(response=>{
                if (response.body.status == 100){
                    this.user = response.body.data;
                    // sessionStorage
                    window.sessionStorage.setItem("email",this.user.email);
                    window.sessionStorage.setItem("username",this.user.username);
                    window.sessionStorage.setItem("profession",this.user.profession);
                    window.sessionStorage.setItem("id",this.user.id);
                    window.sessionStorage.setItem("phone",this.user.phone);
                    this.loginModal(0);
                }else if (response.body.status == 250){
                    //跳转到管理员页面
                    window.location.href="admin/index.html";
                }else if (response.body.status == 500){
                    alert(response.body.msg);
                }
            },response=>{
                console.log("error!");
            });
        },
        register:function () {
            // 注册
            // 相关注册逻辑判定
            const params={"username":this.regUser.regInputUserName,"password":this.regUser.regInputPassword,
            "phone":this.regUser.regInputPhone,"email":this.regUser.regInputEmail,"profession":this.regUser.regInputPro};
            this.$http.post("http://127.0.0.1:9091/customer/user",JSON.stringify(params)).then(response=>{
                if (response.body.status == 100){
                    // sessionStorage
                    alert("注册成功！");
                    window.sessionStorage.setItem("email",this.regUser.regInputEmail);
                    window.sessionStorage.setItem("username",this.regUser.regInputUserName);
                    window.sessionStorage.setItem("profession",this.regUser.regInputPro);
                    window.sessionStorage.setItem("phone",this.regUser.regInputPhone);
                    this.regModal(0);
                }else if (response.body.status == 500){
                    alert(response.body.msg+"！");
                }
            },response=>{
                console.log("error!");
            });
        },
        logout:function () {
        //     注销
            const params={"userId":this.user.id};
            this.$http.get("http://127.0.0.1:9091/customer/logout",{params:params}).then(response=>{
                if (response.body.status == 100){
                    alert("注销成功！");
                    window.sessionStorage.clear();
                    window.location = '/index.html';
                    this.isClickMenu = false;
                }
            },response=>{
                console.log("error!");
            });
        },
        submitRemark:function () {
            // 提交评论事件
            // 取得现有楼层，新评论要 +1
            var newMessagesFloor = this.detail.messages.length + 1;
            var updatedTime = getNowDate();
            var updatedUser = window.sessionStorage.username;
            var userId = window.sessionStorage.id;
            //  如果是回复别人 就要截取字符串
            if (this.messagedObject){
                var messageContent = this.remarkContent.substring(this.messagedObject.length,this.remarkContent.length);
                updatedUser += " " + this.messagedObject.substring(0,this.messagedObject.length - 1);　
            //    评论者变为　ｘｘ回复ｘｘ
            }else{
                //　不是回复
                var messageContent = this.remarkContent;
            }
            const params={"articleId":this.detail.id,"content":messageContent,"floor":newMessagesFloor,"updatedTime":updatedTime,"updatedUser":updatedUser,"userId":userId};
            this.$http.post("http://127.0.0.1:9091/message/message",params).then(response=>{
                if (response.body.status == 100){
                    // 将传进来的文章的likeNumber设置为返回的data值
                    alert("留言成功！");
                    this.remarkContent = "";
                    this.messagedObject = null;
                    this.showArticleDetails(this.detail.id);
                }else if(response.body.status == 500){
                    alert(response.body.msg);
                }
            },response=>{
                console.log("error!");
            });
        },
        replyMessage:function(messagedfloor) {
                // 回复消息
            var updatedUser =window.sessionStorage.username;// 存储已登录的用户
            if (updatedUser == messagedfloor.updatedUser){
                alert("不能对自己评论！");
                return;
            }
            // 拼接
            this.messagedObject = "回复--" + messagedfloor.floor + "楼--" + messagedfloor.updatedUser + ":";
            this.remarkContent = this.messagedObject;
        }
    },
    filters:{
        // 时间过滤器
        timeFormat(time){
            var day = new Date();
            day.setTime(day.getTime());
            // 返回评论日期：     年-月-日
           return day.getFullYear() + "-" + (day.getMonth() + 1) + "-" + day.getDate();
        }
    },
    computed:{
        // 限制最多显示的文章数
        articleLimit:function () {
            return this.article.slice(0,this.articleLimitValue);
        },
        // 评论倒序
        remarkMessage:function () {
            return this.detail.messages.reverse();
        }
    }
})