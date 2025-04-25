<template>
	<div>
		<div class="login-container">
			<el-form class="login_form animate__animated animate__backInDown">
				<div class="login_form2">
					<div class="title-container">在线教育教学管理系统设计与实现</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							账号
						</div>
						<input placeholder="请输入账号" name="username" type="text" v-model="rulesForm.username">
					</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							密码
						</div>
						<div class="password-box">
							<input placeholder="请输入密码" name="password" :type="showPassword?'text':'password'" v-model="rulesForm.password">
							<span class="icon iconfont" :class="showPassword?'icon-liulan13':'icon-liulan17'" @click="showPassword=!showPassword"></span>
						</div>
					</div>

					<div class="list-item " v-if="roles.length>1">
						<div class="lable">
							角色
						</div>
						<div prop="loginInRole" class="list-type">
							<el-radio v-if="loginType==1||(loginType==2&&item.roleName!='管理员')" v-for="item in roles" v-bind:key="item.roleName" v-model="rulesForm.role" :label="item.roleName">{{item.roleName}}</el-radio>
						</div>
					</div>

		
					<div class="login-btn">
						<div class="login-btn1">
							<el-button v-if="loginType==1" type="primary" @click="login()" class="loginInBt">登录</el-button>
						</div>
						<div class="login-btn2">
							<el-button type="primary" @click="register('jiaoshi')" class="register">
								注册教师							</el-button>
						</div>
						<div class="login-btn3">
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
	import menu from "@/utils/menu";
	export default {
		data() {
			return {
				verifyCheck2: false,
				flag: false,
				baseUrl:this.$base.url,
				loginType: 1,
				rulesForm: {
					username: "",
					password: "",
					role: "",
				},
				menus: [],
				roles: [],
				tableName: "",
				showPassword: false,
			};
		},
		mounted() {
			let menus = menu.list();
			this.menus = menus;

			for (let i = 0; i < this.menus.length; i++) {
				if (this.menus[i].hasBackLogin=='是') {
					this.roles.push(this.menus[i])
				}
			}

		},
		created() {

		},
		destroyed() {
		},
		components: {
		},
		methods: {

			//注册
			register(tableName){
				this.$storage.set("loginTable", tableName);
				this.$router.push({path:'/register',query:{pageFlag:'register'}})
			},
			// 登陆
			login() {

				if (!this.rulesForm.username) {
					this.$message.error("请输入用户名");
					return;
				}
				if (!this.rulesForm.password) {
					this.$message.error("请输入密码");
					return;
				}
				if(this.roles.length>1) {
					if (!this.rulesForm.role) {
						this.$message.error("请选择角色");
						return;
					}

					let menus = this.menus;
					for (let i = 0; i < menus.length; i++) {
						if (menus[i].roleName == this.rulesForm.role) {
							this.tableName = menus[i].tableName;
						}
					}
				} else {
					this.tableName = this.roles[0].tableName;
					this.rulesForm.role = this.roles[0].roleName;
				}
		
				this.loginPost()
			},
			loginPost() {
				this.$http({
					url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
					method: "post"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.$storage.set("Token", data.token);
						this.$storage.set("role", this.rulesForm.role);
						this.$storage.set("sessionTable", this.tableName);
						this.$storage.set("adminName", this.rulesForm.username);
						this.$router.replace({ path: "/" });
					} else {
						this.$message.error(data.msg);
					}
				});
			},
		}
	}
</script>

<style lang="scss" scoped>
.login-container {
	min-height: 100vh;
	position: relative;
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
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

	.login_form {
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
		.login_form2 {
			background-color: rgba(0,0,0,0.5);
			backdrop-filter: blur(10px);
			padding: 0 40px;
			width: 610px;
			height: 100%;
		}
		.title-container {
			padding: 0;
			margin: 120px 0 40px 0;
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
			.lable {
				color: #A3AECC;
				flex: 0 0 auto;
				width: 80px;
				font-size: 14px;
				line-height: 40px;
				text-align: left;
			}
			input {
				border: 0px solid #efeff7;
				background-color: transparent;
				border-radius: 4px;
				padding: 0 10px;
				outline: none;
				color: #fff;
				flex: 1 1 auto;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
			input:focus {
				border: 0px solid #efeff7;
				background-color: transparent;
				border-radius: 4px;
				padding: 0 10px;
				color: #fff;
				flex: 1 1 auto;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
			.password-box {
				display: flex;
				width: 100%;
				position: relative;
				align-items: center;
				input {
					border: 0px solid #efeff7;
					background-color: transparent;
					border-radius: 4px;
					padding: 0 10px;
					color: #fff;
					flex: 1 1 auto;
					width: auto;
					font-size: 14px;
					height: 40px;
				}
				input:focus {
					border: 0px solid #efeff7;
					background-color: transparent;
					border-radius: 4px;
					padding: 0 10px;
					color: #fff;
					flex: 1 1 auto;
					width: auto;
					font-size: 14px;
					height: 40px;
				}
				.iconfont {
					cursor: pointer;
					z-index: 1;
					color: #fff;
					top: 0;
					font-size: 16px;
					line-height: 44px;
					position: absolute;
					right: 5px;
				}
			}
			input::placeholder {
				color: #999;
				font-size: 16px;
			}
		}
		.list-type {
			padding: 0;
			margin: 0;
			background: none;
			width: calc(100% - 0px);
			line-height: 40px;
			height: auto;
			/deep/ .el-radio__input .el-radio__inner {
				background: rgba(53, 53, 53, 0);
				border-color: #fff;
			}
			/deep/ .el-radio__input.is-checked .el-radio__inner {
				background: #0d6efd;
				border-color: #0d6efd;
			}
			/deep/ .el-radio__label {
				color: #fff;
				font-size: 14px;
			}
			/deep/ .el-radio__input.is-checked+.el-radio__label {
				color: #0d6efd;
				font-size: 14px;
			}
		}
		.login-btn {
			margin: 20px auto;
			display: flex;
			width: 100%;
			justify-content: center;
			align-items: center;
			flex-wrap: wrap;
			.login-btn1 {
				width: 100%;
			}
			.login-btn2 {
				display: flex;
				gap: 20px;
				width: 100%;
				justify-content: center;
				align-items: center;
				flex-wrap: wrap;
			}
			.login-btn3 {
				width: 100%;
				order: -1;
			}
			.loginInBt {
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
			.loginInBt:hover {
				opacity: 0.8;
			}
			.register {
				border: 1px solid #A3AECC;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 10px;
				margin: 0 0 10px;
				color: #A3AECC;
				background: transparent;
				width: auto;
				font-size: 16px;
				height: 34px;
			}
			.register:hover {
				opacity: 0.8;
			}
			.forget {
				border: 0;
				cursor: pointer;
				border-radius: 0;
				padding: 0;
				margin: 0 10px 10px 0;
				color: #fff;
				background: none;
				width: 100%;
				font-size: 16px;
				text-align: center;
				height: 34px;
			}
			.forget:hover {
				color: #0d6efd;
				opacity: 1;
			}
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

</style>
