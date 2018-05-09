var vm = new Vue({
    el:'#app',
    data(){
        return{
            isInContentAdmin: false,
            isInCategoryAdmin: false,
            isInUserAdmin:false,
            tableTd:[],
            title:'',
            contentList:[],
            article:{
                category:'', //分类
                title:'',     // 标题
                introduction:'',     // 简介
                content:'',     // 内容
            }
        }
    },
    methods:{
        showContentIndex:function() {
            this.isInContentAdmin = true;
            this.isInCategoryAdmin = false;
            this.isInUserAdmin = false;
            this.title = "内容首页";
            this.getContentData();
        },
        getContentData:function () {
            // 内容管理请求数据
            this.$http.get("http://127.0.0.1:9091/article/article/index").then(response => {
                // 获取到请求的 文章数据
                this.contentList = response.body.data;
                this.tableTd = ['ID','分类名称','标题','作者','添加时间','阅读量','操作'];
            }, response => {
                console.log("error!");
            });
        },
        showCategoryIndex:function () {
            this.isInCategoryAdmin = true;
            this.isInContentAdmin = false;
            this.isInUserAdmin = false;
            this.title = "分类首页";
            this.getCategoryData();
        },
        getCategoryData:function () {
            // 分类首页请求数据
            this.$http.get("http://127.0.0.1:9091/article/category/list").then(response => {
                // 获取到请求的 分类数据
                this.contentList = response.body.data;
                this.tableTd = ['ID','分类名称','操作'];
            }, response => {
                console.log("error!");
            });
        },
        showUserIndex:function () {
            this.isInUserAdmin = true;
            this.isInCategoryAdmin = false;
            this.isInContentAdmin = false;
            this.title = '用户列表';
            this.getUserData();
        },
        getUserData:function () {
            // 用户首页请求数据
            this.$http.get("http://127.0.0.1:9091/customer/userList").then(response => {
                // 获取到请求的 用户数据
                this.contentList = response.body.data;
                this.tableTd = ['ID','用户名','职业','电话','邮箱'];
            }, response => {
                console.log("error!");
            });
        }
    },
    mounted(){

    },
    computed:{
        contentListLimit:function () {
             return this.contentList.slice(0,this.contentListLimitValue);
        }
    }
})