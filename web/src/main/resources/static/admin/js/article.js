var vm2 = new Vue({
    el:'#article',
    data(){
        return{
            article:{
                category:'', //分类
                title:'',     // 标题
                introduction:'',     // 简介
                content:'',     // 内容
            }
        }
    },
    methods:{
        addArticle:function () {
            const params={"categoryId":this.article.category,"title":this.article.title,
                "introduction":this.article.introduction,"content":this.article.content};
            this.$http.post("http://127.0.0.1:9091/article/article",JSON.stringify(params)).then(response=>{
                if (response.body.status == 100){
                    // sessionStorage
                    alert(response.body.msg);
                    window.location = '/content_add.html';
                }else if (response.body.status == 500){
                    alert(response.body.msg+"！");
                }
            },response=>{
                console.log("error!");
            });
        }
    },
    mounted(){

    },
    computed:{
    }
})