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
            isIndex : true,         // 是不是在首页
            isList:false,           // 是不是在列表页
            isDetail:false,         // 是不是在详情页
            active :0,          // 控制菜单烂active类
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
        login:function () {
            // 登录
        },
        register:function () {
            // 注册
        },
        submitRemark:function () {
            // 提交评论事件
            // 取得现有楼层，新评论要 +1
            var newMessagesFloor = this.detail.messages.length + 1;
            var updatedTime = getNowDate();
            var updatedUser = "Oliver";
            var userId = "619d5a25-986e-46f5-84a9-e0eeee00a592";
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
                }
            },response=>{
                console.log("error!");
            });
        },
        replyMessage:function(messagedfloor) {
                // 回复消息
            var updatedUser = "Oliver";  // 存储已登录的用户
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