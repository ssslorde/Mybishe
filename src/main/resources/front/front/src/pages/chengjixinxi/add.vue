<template>
	<div class="add-update-preview">
		<el-form
			class="add-update-form"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
			>
			<el-form-item class="add-item" label="成绩编号" prop="chengjibianhao">
				<el-input v-model="ruleForm.chengjibianhao" placeholder="成绩编号" disabled></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="课程名称" prop="kechengmingcheng">
				<el-input v-model="ruleForm.kechengmingcheng" 
					placeholder="课程名称" clearable :disabled=" false  ||ro.kechengmingcheng"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="课程封面" v-if="type!='cross' || (type=='cross' && !ro.kechengfengmian)" prop="kechengfengmian">
				<file-upload
					tip="点击上传课程封面"
					action="file/upload"
					:limit="3"
					:multiple="true"
					:fileUrls="ruleForm.kechengfengmian?ruleForm.kechengfengmian:''"
					@change="kechengfengmianUploadChange"
					></file-upload>
			</el-form-item>
			<el-form-item class="add-item" v-else label="课程封面" prop="kechengfengmian">
				<img v-if="ruleForm.kechengfengmian.substring(0,4)=='http'" class="upload-img" v-bind:key="index" :src="ruleForm.kechengfengmian.split(',')[0]">
				<img v-else class="upload-img" v-bind:key="index" v-for="(item,index) in ruleForm.kechengfengmian.split(',')" :src="baseUrl+item">
			</el-form-item>
			<el-form-item class="add-item"  label="学科" prop="xueke">
				<el-select v-model="ruleForm.xueke" placeholder="请选择学科" :disabled=" false  ||ro.xueke" >
					<el-option
						v-for="(item,index) in xuekeOptions"
						:key="index"
						:label="item"
						:value="item">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item class="add-item" label="发布时间" prop="fabushijian">
				<el-input v-model="ruleForm.fabushijian" 
					placeholder="发布时间" clearable :disabled=" false  ||ro.fabushijian"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="作业要求" prop="zuoyeyaoqiu">
				<el-input v-model="ruleForm.zuoyeyaoqiu" 
					placeholder="作业要求" clearable :disabled=" false  ||ro.zuoyeyaoqiu"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="作业提交" prop="zuoyetijiao">
				<file-upload
					tip="点击上传作业提交"
					action="file/upload"
					:limit="1"
					:type="3"
					:multiple="true"
					:fileUrls="ruleForm.zuoyetijiao?ruleForm.zuoyetijiao:''"
					@change="zuoyetijiaoUploadChange"
					></file-upload>
			</el-form-item>  
			<el-form-item class="add-item" label="提交时间" prop="tijiaoshijian">
				<el-input v-model="ruleForm.tijiaoshijian" 
					placeholder="提交时间" clearable :disabled="true  ||ro.tijiaoshijian"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="教师账号" prop="jiaoshizhanghao">
				<el-input v-model="ruleForm.jiaoshizhanghao" 
					placeholder="教师账号" clearable :disabled=" false  ||ro.jiaoshizhanghao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="教师姓名" prop="jiaoshixingming">
				<el-input v-model="ruleForm.jiaoshixingming" 
					placeholder="教师姓名" clearable :disabled=" false  ||ro.jiaoshixingming"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="学号" prop="xuehao">
				<el-input v-model="ruleForm.xuehao" 
					placeholder="学号" clearable :disabled=" false  ||ro.xuehao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="姓名" prop="xingming">
				<el-input v-model="ruleForm.xingming" 
					placeholder="姓名" clearable :disabled=" false  ||ro.xingming"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="作业成绩" prop="zuoyechengji">
				<el-input-number v-model="ruleForm.zuoyechengji" placeholder="作业成绩" :disabled=" false ||ro.zuoyechengji"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="批语" prop="piyu">
				<el-input
					type="textarea"
					:rows="8"
					placeholder="批语"
					v-model="ruleForm.piyu">
					</el-input>
			</el-form-item>

			<el-form-item class="add-btn-item">
				<el-button class="submitBtn"  type="primary" @click="onSubmit">
					<span class="icon iconfont "></span>
					<span class="text">提交信息</span>
				</el-button>
				<el-button class="closeBtn" @click="back()">
					<span class="icon iconfont "></span>
					<span class="text">取消</span>
				</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				id: '',
				baseUrl: '',
				ro:{
					chengjibianhao : false,
					kechengmingcheng : false,
					kechengfengmian : false,
					xueke : false,
					fabushijian : false,
					zuoyeyaoqiu : false,
					zuoyetijiao : false,
					tijiaoshijian : false,
					jiaoshizhanghao : false,
					jiaoshixingming : false,
					xuehao : false,
					xingming : false,
					zuoyechengji : false,
					piyu : false,
				},
				type: '',
				userTableName: localStorage.getItem('UserTableName'),
				ruleForm: {
					chengjibianhao: this.getUUID(),
					kechengmingcheng: '',
					kechengfengmian: '',
					xueke: '',
					fabushijian: '',
					zuoyeyaoqiu: '',
					zuoyetijiao: '',
					tijiaoshijian: '',
					jiaoshizhanghao: '',
					jiaoshixingming: '',
					xuehao: '',
					xingming: '',
					zuoyechengji: '',
					piyu: '',
				},
				xuekeOptions: [],


				rules: {
					chengjibianhao: [
					],
					kechengmingcheng: [
					],
					kechengfengmian: [
					],
					xueke: [
					],
					fabushijian: [
					],
					zuoyeyaoqiu: [
					],
					zuoyetijiao: [
					],
					tijiaoshijian: [
					],
					jiaoshizhanghao: [
					],
					jiaoshixingming: [
					],
					xuehao: [
					],
					xingming: [
					],
					zuoyechengji: [
						{ required: true, message: '作业成绩不能为空', trigger: 'blur' },
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					piyu: [
						{ required: true, message: '批语不能为空', trigger: 'blur' },
					],
				},
				centerType: false,
			};
		},
		computed: {



		},
		components: {
		},
		created() {
			if(this.$route.query.centerType){
				this.centerType = true
			}
			//this.bg();
			let type = this.$route.query.type ? this.$route.query.type : '';
			this.init(type);
			this.baseUrl = this.$config.baseUrl;
		},
		methods: {
			getMakeZero(s) {
				return s < 10 ? '0' + s : s;
			},
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(type) {
				this.type = type;
				if(type=='cross'){
					var obj = JSON.parse(localStorage.getItem('crossObj'));
					for (var o in obj){
						if(o=='chengjibianhao'){
							this.ruleForm.chengjibianhao = obj[o];
							this.ro.chengjibianhao = true;
							continue;
						}
						if(o=='kechengmingcheng'){
							this.ruleForm.kechengmingcheng = obj[o];
							this.ro.kechengmingcheng = true;
							continue;
						}
						if(o=='kechengfengmian'){
							this.ruleForm.kechengfengmian = obj[o].split(",")[0];
							this.ro.kechengfengmian = true;
							continue;
						}
						if(o=='xueke'){
							this.ruleForm.xueke = obj[o];
							this.ro.xueke = true;
							continue;
						}
						if(o=='fabushijian'){
							this.ruleForm.fabushijian = obj[o];
							this.ro.fabushijian = true;
							continue;
						}
						if(o=='zuoyeyaoqiu'){
							this.ruleForm.zuoyeyaoqiu = obj[o];
							this.ro.zuoyeyaoqiu = true;
							continue;
						}
						if(o=='zuoyetijiao'){
							this.ruleForm.zuoyetijiao = obj[o];
							this.ro.zuoyetijiao = true;
							continue;
						}
						if(o=='tijiaoshijian'){
							this.ruleForm.tijiaoshijian = obj[o];
							this.ro.tijiaoshijian = true;
							continue;
						}
						if(o=='jiaoshizhanghao'){
							this.ruleForm.jiaoshizhanghao = obj[o];
							this.ro.jiaoshizhanghao = true;
							continue;
						}
						if(o=='jiaoshixingming'){
							this.ruleForm.jiaoshixingming = obj[o];
							this.ro.jiaoshixingming = true;
							continue;
						}
						if(o=='xuehao'){
							this.ruleForm.xuehao = obj[o];
							this.ro.xuehao = true;
							continue;
						}
						if(o=='xingming'){
							this.ruleForm.xingming = obj[o];
							this.ro.xingming = true;
							continue;
						}
						if(o=='zuoyechengji'){
							this.ruleForm.zuoyechengji = obj[o];
							this.ro.zuoyechengji = true;
							continue;
						}
						if(o=='piyu'){
							this.ruleForm.piyu = obj[o];
							this.ro.piyu = true;
							continue;
						}
					}
				}else if(type=='edit'){
					this.info()
				}
				// 获取用户信息
				this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						var json = res.data.data;
						if((json.jiaoshizhanghao!=''&&json.jiaoshizhanghao) || json.jiaoshizhanghao==0){
							this.ruleForm.jiaoshizhanghao = json.jiaoshizhanghao;
							this.ro.jiaoshizhanghao = true;
						}
						if((json.jiaoshixingming!=''&&json.jiaoshixingming) || json.jiaoshixingming==0){
							this.ruleForm.jiaoshixingming = json.jiaoshixingming;
							this.ro.jiaoshixingming = true;
						}
					}
				});
				this.$http.get('option/xueke/xueke', {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						this.xuekeOptions = res.data.data;
					}
				});

				if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
					localStorage.removeItem('raffleType')
					setTimeout(() => {
						this.onSubmit()
					}, 300)
				}
			},

			// 多级联动参数
			// 多级联动参数
			info() {
				this.$http.get(`chengjixinxi/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						this.ruleForm = res.data.data;
					}
				});
			},
			// 提交
			async onSubmit() {
				if(this.ruleForm.chengjibianhao){
					this.ruleForm.chengjibianhao = String(this.ruleForm.chengjibianhao)
				}
				await this.$refs["ruleForm"].validate(async valid => {
					if(valid) {
						if(this.type=='cross'){
							var statusColumnName = localStorage.getItem('statusColumnName');
							var statusColumnValue = localStorage.getItem('statusColumnValue');
							if(statusColumnName && statusColumnName!='') {
								var obj = JSON.parse(localStorage.getItem('crossObj'));
								if(!statusColumnName.startsWith("[")) {
									for (var o in obj){
										if(o==statusColumnName){
											obj[o] = statusColumnValue;
										}
									}
									var table = localStorage.getItem('crossTable');
									await this.$http.post(table+'/update', obj).then(res => {});
								}
							}
						}


						await this.$http.post(`chengjixinxi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(async res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
										
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
							}
						});
					}
				});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.$router.go(-1);
			},
			kechengfengmianUploadChange(fileUrls) {
				this.ruleForm.kechengfengmian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
			},
			zuoyetijiaoUploadChange(fileUrls) {
				this.ruleForm.zuoyetijiao = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
			},
		}
	};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.add-update-preview {
		padding: 0 0 20px;
		margin: 0px auto;
		color: #666;
		background: none;
		width: 1200px;
		font-size: 16px;
		position: relative;
		.add-update-form {
			padding: 40px;
			margin: 20px 0 0;
			background: #fff;
			width: 100%;
			position: relative;
			.add-item.el-form-item {
				border-radius: 0px;
				padding: 6px 0 0;
				margin: 0 0 20px 0;
				background: #fff;
				border-color: #475a8310;
				border-width:  0 0 0px;
				border-style: solid;
				/deep/ .el-form-item__label {
					padding: 0 10px 0 0;
					color: #666;
					font-weight: 500;
					width: 180px;
					font-size: inherit;
					line-height: 40px;
					text-align: right;
				}
				/deep/ .el-form-item__content {
					margin-left: 180px;
				}
				.el-input {
					width: auto;
				}
				.el-input /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 8px;
					padding: 0 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input /deep/ .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: rgba(85, 85, 127, 1.0);
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .el-input__inner {
					text-align: left;
					border: 1px solid #ddd;
					border-radius: 8px;
					padding: 0 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .is-disabled .el-input__inner {
					text-align: left;
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: rgba(85, 85, 127, 1.0);
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .el-input-number__decrease {
					display: none;
				}
				.el-input-number /deep/ .el-input-number__increase {
					display: none;
				}
				.el-select {
					width: auto;
				}
				.el-select /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 8px;
					padding: 0 10px;
					color: inherit;
					width: 100%;
					font-size: 16px;
					min-width: inherit !important;
					height: 40px;
				}
				.el-select /deep/ .is-disabled .el-input__inner {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 10px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: 100%;
					font-size: 16px;
					height: 40px;
				}
				.el-date-editor {
					width: auto;
				}
				.el-date-editor /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 8px;
					padding: 0 10px 0 30px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 10px 0 30px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
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
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 8px;
					color: #999;
					background: #fff;
					width: 90px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
				}
				/deep/ .el-upload-list .el-upload-list__item {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 8px;
					color: #999;
					background: #fff;
					width: 90px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
					font-size: 14px;
					line-height: 1.8;
				}
				/deep/ .el-upload .el-icon-plus {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 8px;
					color: #999;
					background: #fff;
					width: 90px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
				}
				/deep/ .el-upload__tip {
					color: #888;
					font-size: 16px;
				}
				.el-textarea /deep/ .el-textarea__inner {
					border: 1px solid #ddd;
					border-radius: 8px;
					padding: 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					min-height: 150px;
					min-width: 48%;
					height: auto;
				}
				.el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
					border: 0px solid #ddd;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 12px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: auto;
					font-size: 16px;
					min-height: 150px;
					min-width: 50%;
					height: auto;
				}
				/deep/ .el-input__inner::placeholder {
					color: inherit;
					font-size: inherit;
				}
				/deep/ textarea::placeholder {
					color: inherit;
					font-size: inherit;
				}
				.editor {
					background-color: #fff;
					border-radius: 0;
					padding: 0;
					box-shadow: none;
					margin: 0;
					width: 100%;
					min-height: 350px;
					border-color: #ccc;
					border-width: 1px;
					border-style: solid;
					height: auto;
				}
				.upload-img {
					border-radius: 8px;
					object-fit: cover;
					width: 100px;
					height: 100px;
				}
				.viewBtn {
					border: 0;
					cursor: pointer;
					border-radius: 4px;
					padding: 0 20px;
					margin: 0;
					color: #333;
					background: #475a8330;
					display: inline-block;
					width: auto;
					font-size: 14px;
					line-height: 34px;
					height: 34px;
				}
				.viewBtn:hover {
				}
				.unviewBtn {
					border: 0;
					cursor: pointer;
					padding: 0 20px;
					margin: 0;
					color: #333;
					display: inline-block;
					font-size: 14px;
					line-height: 34px;
					border-radius: 4px;
					outline: none;
					background: #ddd;
					width: auto;
					height: 34px;
				}
				.unviewBtn:hover {
				}
			}
			.add-btn-item {
				padding: 0;
				margin: 20px 0;
				text-align: center;
				.submitBtn {
					border: 0;
					cursor: pointer;
					border-radius: 0px;
					padding: 0 24px 0 30px;
					margin: 0 20px 0 0;
					background: #1b4955;
					display: inline-block;
					width: auto;
					font-size: 16px;
					line-height: 40px;
					min-width: 140px;
					height: 40px;
					.icon {
						color: #fff;
					}
					.text {
						color: #fff;
					}
				}
				.submitBtn:hover {
					color: #fff;
					.icon {
					}
					.text {
					}
				}
				.closeBtn {
					border: 0px solid #ddd;
					cursor: pointer;
					padding: 0 24px 0 30px;
					margin: 0 20px 0 0;
					color: #fff;
					display: inline-block;
					font-size: 16px;
					line-height: 40px;
					border-radius: 0px;
					background: #01898b;
					width: auto;
					min-width: 140px;
					height: 40px;
					.icon {
						color: #fff;
					}
					.text {
						color: #fff;
						text-align: center;
					}
				}
				.closeBtn:hover {
					color: #fff;
					.icon {
					}
					.text {
						color: #fff;
						text-align: center;
					}
				}
			}
		}
	}
	.el-date-editor.el-input {
		width: auto;
	}
</style>
