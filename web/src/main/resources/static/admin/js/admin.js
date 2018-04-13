var vm = new Vue({
    el:'#app',
    data(){
        return{
            isInContentAdmin:false,
            contentList:[],
        }
    },
    methods:{
        showContentIndex:function() {
            this.isInContentAdmin = true;
            this.getContentData();
        },
        getContentData:function () {
            this.$http.get("http://127.0.0.1:9091/article/article/index").then(response => {
                // 获取到请求的 文章数据
                this.contentList = response.body.data;
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