# Blogs

1.将项目导入您的IDE，加载相关的依赖包

2.下载好必要的两个服务器，Nginx和FTP服务器，FTP文件服务器用作上传的图片，Nginx用作反向代理，如果嫌麻烦，文件上传可以只上传到本地，只要修改代码即可。

3.一定要下载Redis，并且运行，否则启动不了。因为项目用到Spring Session+Redis统一Session信息

4.先启动Server的入口类，再启动其他模块的入口类，访问 http://127.0.0.1:9091/index.html 即可。
