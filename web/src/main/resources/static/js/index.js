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
            moreMessage:"...显示更多"
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
        login:function () {
            // 登录
        },
        register:function () {
            // 注册
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
        }
    }
})