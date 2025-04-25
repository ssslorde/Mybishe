const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot1y6mspy8/",
            name: "springboot1y6mspy8",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot1y6mspy8/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "在线教育教学管理系统设计与实现"
        } 
    }
}
export default base
