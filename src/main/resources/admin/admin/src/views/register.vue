<template>
	<div>
		<div class="register-container">
			<el-form v-if="pageFlag=='register'" ref="ruleForm" class="rgs-form animate__animated animate__backInDown" :model="ruleForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">在线教育教学管理系统设计与实现</div>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'">
						<div class="lable" :class="changeRules('xuehao')?'required':''">学号：</div>
						<el-input  v-model="ruleForm.xuehao"  autocomplete="off" placeholder="学号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'">
						<div class="lable" :class="changeRules('xingming')?'required':''">姓名：</div>
						<el-input  v-model="ruleForm.xingming"  autocomplete="off" placeholder="姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in xueshengxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'">
						<div class="lable" :class="changeRules('shoujihao')?'required':''">手机号：</div>
						<el-input  v-model="ruleForm.shoujihao"  autocomplete="off" placeholder="手机号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="xueshengtouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiaoshi'">
						<div class="lable" :class="changeRules('jiaoshizhanghao')?'required':''">教师账号：</div>
						<el-input  v-model="ruleForm.jiaoshizhanghao"  autocomplete="off" placeholder="教师账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiaoshi'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiaoshi'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiaoshi'">
						<div class="lable" :class="changeRules('jiaoshixingming')?'required':''">教师姓名：</div>
						<el-input  v-model="ruleForm.jiaoshixingming"  autocomplete="off" placeholder="教师姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiaoshi'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in jiaoshixingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiaoshi'">
						<div class="lable" :class="changeRules('lianxifangshi')?'required':''">联系方式：</div>
						<el-input  v-model="ruleForm.lianxifangshi"  autocomplete="off" placeholder="联系方式"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiaoshi'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="jiaoshitouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<button type="button" class="r-btn" @click="login()">注册</button>
						</div>
						<div class="register-btn2">
							<div class="r-login" @click="close()">已有账号，直接登录</div>
						</div>
					</div>
				</div>
				<div class="idea-box1">毕业快乐</div>
				<div class="idea-box2">Happy Graduation</div>
			</el-form>
		</div>
	</div>
</template>

<script>
	import 'animate.css'
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            xueshengxingbieOptions: [],
            jiaoshixingbieOptions: [],
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='xuesheng'){
				this.ruleForm = {
					xuehao: '',
					mima: '',
					xingming: '',
					xingbie: '',
					shoujihao: '',
					touxiang: '',
				}
			}
			if(this.tableName=='jiaoshi'){
				this.ruleForm = {
					jiaoshizhanghao: '',
					mima: '',
					jiaoshixingming: '',
					xingbie: '',
					lianxifangshi: '',
					touxiang: '',
				}
			}
			if ('xuesheng' == this.tableName) {
				this.rules.xuehao = [{ required: true, message: '请输入学号', trigger: 'blur' }]
			}
			if ('xuesheng' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('xuesheng' == this.tableName) {
				this.rules.xingming = [{ required: true, message: '请输入姓名', trigger: 'blur' }]
			}
			if ('jiaoshi' == this.tableName) {
				this.rules.jiaoshizhanghao = [{ required: true, message: '请输入教师账号', trigger: 'blur' }]
			}
			if ('jiaoshi' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('jiaoshi' == this.tableName) {
				this.rules.jiaoshixingming = [{ required: true, message: '请输入教师姓名', trigger: 'blur' }]
			}
			this.xueshengxingbieOptions = "男,女".split(',')
			this.jiaoshixingbieOptions = "男,女".split(',')
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        xueshengtouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        jiaoshitouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
			if((!this.ruleForm.xuehao) && `xuesheng` == this.tableName){
				this.$message.error(`学号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `xuesheng` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `xuesheng` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if((!this.ruleForm.xingming) && `xuesheng` == this.tableName){
				this.$message.error(`姓名不能为空`);
				return
			}
			if(`xuesheng` == this.tableName && this.ruleForm.shoujihao &&(!this.$validate.isMobile(this.ruleForm.shoujihao))){
				this.$message.error(`手机号应输入手机格式`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if((!this.ruleForm.jiaoshizhanghao) && `jiaoshi` == this.tableName){
				this.$message.error(`教师账号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `jiaoshi` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `jiaoshi` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if((!this.ruleForm.jiaoshixingming) && `jiaoshi` == this.tableName){
				this.$message.error(`教师姓名不能为空`);
				return
			}
			if(`jiaoshi` == this.tableName && this.ruleForm.lianxifangshi &&(!this.$validate.isMobile(this.ruleForm.lianxifangshi))){
				this.$message.error(`联系方式应输入手机格式`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
.register-container {
	position: relative;
	background: url(http://codegen.caihongy.cn/20241008/98dbe9386da44aac94a3d2b8e62f1ea2.webp);
	background-repeat: no-repeat;
	background-size: cover;
	background: url(http://codegen.caihongy.cn/20241008/98dbe9386da44aac94a3d2b8e62f1ea2.webp);
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: center;
	align-items: center;
	background-position: center center;
	.rgs-form {
		.rgs-form2 {
		scrollbar-width: thin;
		background-color: rgba(0,0,0,0.5);
		backdrop-filter: blur(10px);
		padding: 0 40px;
		width: 610px;
		overflow-y: auto;
		height: 100%;
		}
		border-radius: 0;
		padding: 0;
		margin: 0;
		z-index: 1000;
		flex-direction: column;
		background: url(http://codegen.caihongy.cn/20241008/b3b32f7d038c43f795fd3b5b2cb65881.webp) no-repeat center center;
		display: flex;
		width: 1426px;
		align-items: flex-end;
		position: relative;
		height: 720px;
		.title {
			padding: 0;
			margin: 20px 0;
			color: #fff;
			background: none;
			font-weight: 600;
			width: 100%;
			font-size: 28px;
			line-height: 40px;
			text-align: center;
		}
		.list-item {
			padding: 0;
			margin: 0 0 40px;
			display: flex;
			width: 100%;
			border-color: #fff;
			border-width: 0 0 2px 0;
			align-items: center;
			position: relative;
			border-style: solid;
			/deep/ .el-form-item__content {
				display: flex;
				width: 100%;
			}
			.lable {
				color: #A3AECC;
				flex: 0 0 auto;
				width: 80px;
				font-size: 14px;
				line-height: 40px;
				text-align: left;
			}
			.el-input {
				flex: 1 1 auto;
				width: 100%;
			}
			.el-input /deep/ .el-input__inner {
				border: 0px solid #efeff7;
				background-color: transparent;
				border-radius: 4px;
				padding: 0 10px;
				outline: none;
				color: #fff;
				width: 100%;
				font-size: 14px;
				height: 40px;
			}
			.el-input /deep/ .el-input__inner:focus {
				border: 0px solid #efeff7;
				background-color: transparent;
				border-radius: 4px;
				padding: 0 10px;
				color: #fff;
				width: 100%;
				font-size: 14px;
				height: 40px;
			}
			.el-input-number {
				flex: 1 1 auto;
				width: 100%;
			}
			.el-input-number /deep/ .el-input__inner {
				text-align: center;
				border: 0px solid #efeff7;
				background-color: transparent;
				border-radius: 4px;
				padding: 0 10px;
				outline: none;
				color: #fff;
				width: 100%;
				font-size: 14px;
				height: 40px;
			}
			.el-input-number /deep/ .el-input__inner:focus {
				border: 0px solid #efeff7;
				background-color: transparent;
				border-radius: 4px;
				padding: 0 10px;
				color: #fff;
				width: 100%;
				font-size: 14px;
				height: 40px;
			}
			.el-input-number /deep/ .el-input-number__decrease {
				display: none;
			}
			.el-input-number /deep/ .el-input-number__increase {
				display: none;
			}
			.el-select {
				flex: 1 1 auto;
				width: 100%;
			}
			.el-select /deep/ .el-input__inner {
				border: 0px solid #efeff7;
				background-color: transparent;
				border-radius: 4px;
				padding: 0 10px;
				color: #fff;
				width: 100%;
				font-size: 14px;
				height: 40px;
			}
			.el-select /deep/ .el-input__inner:focus {
				border: 0px solid #efeff7;
				background-color: transparent;
				border-radius: 4px;
				padding: 0 10px;
				color: #fff;
				width: 100%;
				font-size: 14px;
				height: 40px;
			}
			.el-date-editor {
				width: 100%;
			}
			.el-date-editor /deep/ .el-input__inner {
				border: 0px solid #efeff7;
				background-color: transparent;
				border-radius: 4px;
				padding: 0 40px;
				color: #fff;
				width: 100%;
				font-size: 14px;
				height: 40px;
			}
			.el-date-editor /deep/ .el-input__inner:focus {
				border: 0px solid #efeff7;
				background-color: transparent;
				border-radius: 4px;
				padding: 0 40px;
				color: #fff;
				width: 100%;
				font-size: 14px;
				height: 40px;
			}
			.el-date-editor.el-input {
				width: 100%;
			}
			/deep/ .el-upload--picture-card {
				background: transparent;
				border: 0;
				border-radius: 0;
				width: auto;
				height: auto;
				line-height: initial;
				vertical-align: middle;
			}
			/deep/ .upload .upload-img {
				border: 1px solid #efeff7;
				cursor: pointer;
				border-radius: 0px;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload-list .el-upload-list__item {
				border: 1px solid #efeff7;
				cursor: pointer;
				border-radius: 0px;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload .el-icon-plus {
				border: 1px solid #efeff7;
				cursor: pointer;
				border-radius: 0px;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload__tip {
				color: #fff;
				font-size: 14px;
			}
			/deep/ .el-input__inner::placeholder {
				color: #999;
				font-size: 14px;
			}
			.required {
				position: relative;
			}
			.required::after{
				color: red;
				left: 0;
				position: inherit;
				content: "*";
				order: -1;
			}
			.editor {
				background: #fff;
				width: 100%;
				height: auto;
			}
			.editor>.avatar-uploader {
				line-height: 0;
				height: 0;
			}
		}
		.list-item.email {
			input {
				border: 0px solid #efeff7;
				background-color: transparent;
				border-radius: 4px;
				padding: 0 10px;
				color: #fff;
				width: 100%;
				font-size: 14px;
				height: 40px;
			}
			input:focus {
				border: 0px solid #efeff7;
				background-color: transparent;
				border-radius: 4px;
				padding: 0 10px;
				color: #fff;
				width: 100%;
				font-size: 14px;
				height: 40px;
			}
			input::placeholder {
				color: #999;
				font-size: 14px;
			}
			button {
				border: 0px solid #efeff7;
				cursor: pointer;
				border-radius: 0 4px 4px 0;
				padding: 0;
				margin: 1px 0 0;
				color: #333;
				background: #0d6efd20;
				width: 150px;
				font-size: 15px;
				height: 38px;
			}
			button:hover {
				opacity: 0.8;
			}
		}
		.register-btn {
			width: 100%;
		}
		.register-btn1 {
			width: 100%;
		}
		.register-btn2 {
			width: 100%;
		}
		.r-btn {
			border: 0px solid rgba(0, 0, 0, 1);
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 0 10px;
			color: #fff;
			background: linear-gradient( 134deg, #5E83B4 0%, #8FAEC1 100%);
			font-weight: 600;
			width: 100%;
			font-size: 24px;
			min-width: 68px;
			height: 44px;
		}
		.r-btn:hover {
			border: 0px solid rgba(0, 0, 0, 1);
			opacity: 0.8;
		}
		.r-login {
			cursor: pointer;
			padding: 0;
			color: #FFFFFF;
			display: inline-block;
			text-decoration: underline;
			width: 100%;
			font-size: 15px;
			line-height: 40px;
			text-align: right;
		}
		.r-login:hover {
			opacity: 1;
		}
	}
	.idea-box1 {
		z-index: -1;
		top: 240px;
		color: #fff;
		left: 240px;
		font-size: 72px;
		position: absolute;
	}
	.idea-box2 {
		z-index: -1;
		top: 340px;
		color: #fff;
		left: 120px;
		font-size: 72px;
		position: absolute;
	}
}
	
	::-webkit-scrollbar {
	  display: none;
	}
</style>
