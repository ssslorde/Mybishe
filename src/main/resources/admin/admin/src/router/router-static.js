import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import adminexam from '@/views/modules/exampaperlist/exam'
	import news from '@/views/modules/news/list'
	import aboutus from '@/views/modules/aboutus/list'
	import examfailrecord from '@/views/modules/examfailrecord/list'
	import xuesheng from '@/views/modules/xuesheng/list'
	import examquestion from '@/views/modules/examquestion/list'
	import jiaoshi from '@/views/modules/jiaoshi/list'
	import zuoyetijiao from '@/views/modules/zuoyetijiao/list'
	import exampaper from '@/views/modules/exampaper/list'
	import discusskechengxinxi from '@/views/modules/discusskechengxinxi/list'
	import kechengxinxi from '@/views/modules/kechengxinxi/list'
	import kechengleixing from '@/views/modules/kechengleixing/list'
	import zuoyexinxi from '@/views/modules/zuoyexinxi/list'
	import cankexinxi from '@/views/modules/cankexinxi/list'
	import xueke from '@/views/modules/xueke/list'
	import systemintro from '@/views/modules/systemintro/list'
	import chengjixinxi from '@/views/modules/chengjixinxi/list'
	import examquestionbank from '@/views/modules/examquestionbank/list'
	import config from '@/views/modules/config/list'
	import examrecord from '@/views/modules/examrecord/list'
	import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/news',
		name: '公告信息',
		component: news
	}
	,{
		path: '/aboutus',
		name: '关于我们',
		component: aboutus
	}
	,{
		path: '/examfailrecord',
		name: '错题本',
		component: examfailrecord
	}
	,{
		path: '/xuesheng',
		name: '学生',
		component: xuesheng
	}
	,{
		path: '/examquestion',
		name: '试题管理',
		component: examquestion
	}
	,{
		path: '/jiaoshi',
		name: '教师',
		component: jiaoshi
	}
	,{
		path: '/zuoyetijiao',
		name: '作业提交',
		component: zuoyetijiao
	}
	,{
		path: '/exampaper',
		name: '在线测试管理',
		component: exampaper
	}
	,{
		path: '/discusskechengxinxi',
		name: '课程信息评论',
		component: discusskechengxinxi
	}
	,{
		path: '/kechengxinxi',
		name: '课程信息',
		component: kechengxinxi
	}
	,{
		path: '/kechengleixing',
		name: '课程类型',
		component: kechengleixing
	}
	,{
		path: '/zuoyexinxi',
		name: '作业信息',
		component: zuoyexinxi
	}
	,{
		path: '/cankexinxi',
		name: '参课信息',
		component: cankexinxi
	}
	,{
		path: '/xueke',
		name: '学科',
		component: xueke
	}
	,{
		path: '/systemintro',
		name: '系统简介',
		component: systemintro
	}
	,{
		path: '/chengjixinxi',
		name: '成绩信息',
		component: chengjixinxi
	}
	,{
		path: '/examquestionbank',
		name: '试题库管理',
		component: examquestionbank
	}
	,{
		path: '/config',
		name: '轮播图管理',
		component: config
	}
	,{
		path: '/examrecord',
		name: '考试记录',
		component: examrecord
	}
	,{
		path: '/newstype',
		name: '公告信息分类',
		component: newstype
	}
	]
	},
	{
		path: '/adminexam',
		name: 'adminexam',
		component: adminexam,
		meta: {icon:'', title:'adminexam'}
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
