<template>
	<div>
		<div class="breadcrumb-preview">
			<el-breadcrumb :separator="''">
				<el-breadcrumb-item class="item1" to="/"><a>首页</a></el-breadcrumb-item>
				<el-breadcrumb-item class="item2" v-for="(item, index) in breadcrumbItem" :key="index"><a>{{item.name}}</a></el-breadcrumb-item>
			</el-breadcrumb>
		</div>
	
		<div class="news-preview-pv">
			<el-form :inline="true" :model="formSearch" class="list-form-pv">
				<el-form-item class="search-item">
					<el-input v-model="title" placeholder="标题"></el-input>
				</el-form-item>
				<el-button class="search-btn" type="primary" @click="getNewsList(1)">
					<span class="icon iconfont icon-chakan5"></span>
					搜索
				</el-button>
			</el-form>
			
			<!-- category -->
			<div class="category-list">
				<div class="item" @click="categoryClick(0)" :class="categoryIndex == 0 ? 'active' : ''">全部</div>
				<div v-for="(item,index) in categoryList" @click="categoryClick(index+1)" :key="index" class="item" :class="categoryIndex == index+1 ? 'active' : ''">{{item.typename}}</div>
			</div>
			<div class="list11">
				<div v-for="(item,index) in newsList" :key="index" :class="'list-item' + ((index%2) + 1)" @click="toNewsDetail(item)">
					<div class="img">
						<img class="image" :src="baseUrl + item.picture" >
					</div>
					<div class="infoBox">
						<div class="name">{{item.title}}</div>
						<div class="desc">{{item.introduction}}</div>
						<div class="infoCenter">
							<div class="publisher_item">
								<span class="icon iconfont" :class="index%2==0?'icon-geren16':'icon-geren16'"></span>
								<span class="label">{{index%2==0?'发布人：':'发布人：'}}</span>
								<span class="text">{{item.name}}</span>
							</div>
							<div class="like_item">
								<span class="icon iconfont" :class="index%2==0?'icon-zan10':'icon-zan10'"></span>
								<span class="label">{{index%2==0?'点赞：':'点赞：'}}</span>
								<span class="text">{{item.thumbsupnum}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont" :class="index%2==0?'icon-shoucang10':'icon-shoucang10'"></span>
								<span class="label">{{index%2==0?'收藏：':'收藏：'}}</span>
								<span class="text">{{item.storeupnum}}</span>
							</div>
							<div class="view_item">
								<span class="icon iconfont" :class="index%2==0?'icon-chakan2':'icon-chakan2'"></span>
								<span class="label">{{index%2==0?'浏览次数：':'浏览次数：'}}</span>
								<span class="text">{{item.clicknum}}</span>
							</div>
						</div>
						<div class="infoBottom">
							<div class="time_item">
								<span class="icon iconfont" :class="index%2==0?'icon-shijian21':'icon-shijian21'"></span>
								<span class="label">{{index%2==0?'发布时间：':'发布时间：'}}</span>
								<span class="text">{{index%2==0? item.addtime.split(' ')[0] : item.addtime.split(' ')[0] }}</span>
							</div>
							<div class="more_btn">
								<span class="text">{{index%2==0?'查看更多':'查看更多'}}</span>
								<span class="icon iconfont" :class="index%2==0?'icon-jiantou25':'icon-jiantou25'"></span>
							</div>
						</div>
					</div>
				</div>
			</div>
		
			<el-pagination
				background
				id="pagination" class="pagination"
				:pager-count="7"
				:page-size="pageSize"
				:page-sizes="pageSizes"
				prev-text="上一页"
				next-text="下一页"
				:hide-on-single-page="false"
				:layout='["total","prev","pager","next","sizes","jumper"].join()'
				:total="total"
				@current-change="curChange"
				@prev-click="prevClick"
				@next-click="nextClick"
				></el-pagination>

			<!-- 热门信息 -->
			<div class="hot">
				<div class="hot-title">热门信息</div>
				<div class="hot-list">
					<div class="hot-item" v-for="item in hotList" :key="item.id" @click="toNewsDetail(item)">
						<img :src="baseUrl + item.picture" alt="">
						<div class="hot-name">{{ item.title }}</div>
						<div class="hot-time">{{item.addtime}}</div>
					</div>
				</div>
			</div>
			<div class="idea1"></div>
		</div>
	</div>
</template>

<script>
	export default {
		//数据集合
		data() {
			return {
				baseUrl: this.$config.baseUrl,
				breadcrumbItem: [
				  {
					name: '公告信息'
				  }
				],
				newsList: [],
				total: 1,
				pageSize: 10,
				pageSizes: [],
				totalPage: 1,
				layouts: '',
				title: '',
				categoryIndex: 0,
				categoryList: [],
				hotList: [],
			}
		},
		created() {
			this.getCategoryList()
			this.getNewsList(1);
			this.getHotList()
		},
		//方法集合
		methods: {
			getCategoryList(){
				this.$http.get('newstype/list', {}).then(res => {
					if (res.data.code == 0) {
						this.categoryList = res.data.data.list
					}
				});
			},
			categoryClick(index) {
				this.categoryIndex = index
				this.getNewsList()
			},
			getNewsList(page) {
				let params = {page, limit: this.pageSize,sort:'addtime',order:'desc'};
				let searchWhere = {};
				if(this.title != '') searchWhere.title = '%' + this.title + '%';
				if(this.categoryIndex!=0){
					searchWhere.typename = this.categoryList[this.categoryIndex - 1].typename
				}
				this.$http.get('news/list', {params: Object.assign(params, searchWhere)}).then(res => {
					if (res.data.code == 0) {
						this.newsList = res.data.data.list;
						this.total = res.data.data.total;
						this.pageSize = Number(res.data.data.pageSize);
						this.totalPage = res.data.data.totalPage;
						if(this.pageSizes.length==0){
							this.pageSizes = [this.pageSize, this.pageSize*2, this.pageSize*3, this.pageSize*5];
						}
					}
				});
			},
			getHotList(){
				let params = {page:1, limit: 4,sort:'addtime',order:'desc'};
				this.$http.get('news/autoSort', {params: params}).then(res => {
					if (res.data.code == 0) {
						this.hotList = res.data.data.list;
					}
				});
			},
			curChange(page) {
				this.getNewsList(page);
			},
			prevClick(page) {
				this.getNewsList(page);
			},
			nextClick(page) {
				this.getNewsList(page);
			},
			toNewsDetail(item) {
				this.$router.push({path: '/index/newsDetail', query: {id: item.id}});
			}
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.news-preview-pv {
				margin: 0px auto;
				color: #333;
				background: none;
				display: flex;
				width: 1200px;
				font-size: 16px;
				justify-content: flex-start;
				align-items: flex-start;
				position: relative;
				flex-wrap: wrap;
				.list-form-pv {
						padding: 10px;
						background: none;
						display: flex;
						width: 100%;
						justify-content: center;
						align-items: center;
						flex-wrap: wrap;
						height: auto;
						.search-item {
								margin: 0 0px;
								.el-input {
										width: 100%;
									}
				.el-input /deep/ .el-input__inner {
										border: 1px solid #ccc;
										border-radius: 0px 0 0 0px;
										padding: 0 10px;
										margin: 0;
										color: #333;
										width: auto;
										font-size: 16px;
										border-width: 1px 0 1px 1px;
										line-height: 42px;
										min-width: 350px;
										height: 42px;
									}
			}
			.search-btn {
								cursor: pointer;
								border: 0;
								border-radius: 0 0px 0px 0;
								padding: 0px 15px;
								margin: 0 10px 0 0;
								color: #fff;
								background: #1b4955;
								width: auto;
								font-size: inherit;
								line-height: 42px;
								height: 42px;
								.icon {
										margin: 0 3px 0 0;
										color: #fff;
										font-size: inherit;
									}
			}
		}
		.category-list {
						padding: 10px 10px 0;
						margin: 20px 0px 0 0;
						background: #1b4955;
						display: flex;
						width: 100%;
						flex-wrap: wrap;
						height: auto;
						order: 6;
						.item {
								cursor: pointer;
								border: 0px solid #475a8350;
								padding: 10px 20px 10px 26px;
								margin: 0 10px 10px 0;
								color: #fff;
								background: none;
								display: flex;
								font-size: 16px;
								justify-content: center;
								align-items: center;
								flex-wrap: wrap;
								min-width: 110px;
							}
			
			.item:hover {
								border-radius: 30px;
								color: #1b4955;
								background: #fff;
							}
			
			.item.active {
								border-radius: 30px;
								color: #1b4955;
								background: #fff;
								font-size: 16px;
							}
		}
		.list11 {
						margin: 30px auto 20px;
						overflow: hidden;
						color: #888;
						width: calc(100% - 0px);
						clear: both;
						font-size: 15px;
						order: 8;
						.list-item1 {
								padding: 0;
								margin: 0 0 10px;
								overflow: hidden;
								background: #fff;
								width: 100%;
								border-color: #ddd;
								border-width: 0 0 0px;
								position: relative;
								border-style: dashed;
								height: auto;
								.img {
										overflow: hidden;
										width: 49%;
										float: left;
										height: 300px;
										img {
												object-fit: cover;
												width: 100%;
												transition: all 0.6s;
												height: 100%;
											}
				}
				.infoBox {
										padding: 20px 20px 0 0;
										width: 49%;
										position: relative;
										float: right;
										height: 100%;
										.name {
												border: 1px solid #ddd;
												padding: 10px;
												color: #333;
												background: none;
												font-weight: 600;
												width: calc(100% - 0px);
												font-size: 18px;
												line-height: 30px;
												position: relative;
											}
					.name::after {
												left: 0;
												background: #d10602;
												bottom: 0;
												width: 0px;
												position: absolute;
												content: "";
												transition: all 0.5s ease;
												height: 0px;
											}
					.desc {
												padding: 0 10px 0 0;
												margin: 30px 0 0;
												overflow: hidden;
												color: #666;
												text-indent: 2em;
												font-size: 15px;
												line-height: 30px;
												height: 60px;
											}
					.infoCenter {
												padding: 20px 0;
												margin: 0px 0 0;
												color: #999;
												display: flex;
												width: 100%;
												justify-content: flex-start;
												flex-wrap: wrap;
												.publisher_item {
														padding: 0 10px 0 0;
														.icon {
																margin: 0 2px 0 0;
																display: none;
																line-height: 1.5;
															}
							.label {
																line-height: 1.5;
															}
							.text {
																line-height: 1.5;
															}
						}
						.like_item {
														padding: 0 10px 0 0;
														.icon {
																margin: 0 2px 0 0;
																display: none;
																line-height: 1.5;
															}
							.label {
																line-height: 1.5;
															}
							.text {
																line-height: 1.5;
															}
						}
						.collect_item {
														padding: 0 10px 0 0;
														.icon {
																margin: 0 2px 0 0;
																display: none;
																line-height: 1.5;
															}
							.label {
																line-height: 1.5;
															}
							.text {
																line-height: 1.5;
															}
						}
						.view_item {
														padding: 0 10px 0 0;
														.icon {
																margin: 0 2px 0 0;
																display: none;
																line-height: 1.5;
															}
							.label {
																line-height: 1.5;
															}
							.text {
																line-height: 1.5;
															}
						}
					}
					.infoBottom {
												margin: 10px 0 0;
												display: flex;
												justify-content: space-between;
												align-items: center;
												flex-wrap: wrap;
												.time_item {
														border: 1px solid #ddd;
														padding: 10px;
														.icon {
																margin: 0 2px 0 0;
																line-height: 1.5;
															}
							.label {
																line-height: 1.5;
															}
							.text {
																line-height: 1.5;
															}
						}
						.more_btn {
														border: 1px solid #ddd;
														border-radius: 0px;
														padding: 10px;
														background: none;
														display: block;
														width: 150px;
														line-height: 1.5;
														text-align: center;
														.text {
																color: inherit;
															}
							.icon {
																color: inherit;
																display: none;
															}
						}
					}
				}
			}
			.list-item1:hover {
								cursor: pointer;
								background: #1b4955;
								border-color: #d10602;
								.img {
					img {
												transform: scale(1.05);
											}
				}
				.infoBox {
										.name {
												border: 1px solid #ddd;
												color: #fff;
												background: none;
											}
					.name::after {
												width: 0px;
											}
					.desc {
												color: #fff;
											}
					.infoCenter {
						.publisher_item {
							.icon {
																color: #fff;
															}
							.label {
																color: #fff;
															}
							.text {
																color: #fff;
															}
						}
						.like_item {
							.icon {
																color: #fff;
															}
							.label {
																color: #fff;
															}
							.text {
																color: #fff;
															}
						}
						.collect_item {
							.icon {
																color: #fff;
															}
							.label {
																color: #fff;
															}
							.text {
																color: #fff;
															}
						}
						.view_item {
							.icon {
																color: #fff;
															}
							.label {
																color: #fff;
															}
							.text {
																color: #fff;
															}
						}
					}
					.infoBottom {
						.time_item {
							.icon {
																color: #fff;
															}
							.label {
																color: #fff;
															}
							.text {
																color: #fff;
															}
						}
						.more_btn {
														background: #ffffff30;
														.text {
																color: #fff;
															}
							.icon {
																color: #fff;
															}
						}
					}
				}
			}
			.list-item2 {
								border: 0px solid #eee;
								padding: 0;
								margin: 0 0 10px;
								overflow: hidden;
								background: #fff;
								display: flex;
								width: 100%;
								position: relative;
								height: auto;
								.img {
										margin: 0 0 0 30px;
										overflow: hidden;
										width: 49%;
										float: right;
										height: 300px;
										order: 2;
										img {
												object-fit: cover;
												width: 100%;
												transition: all 0.6s;
												height: 100%;
											}
				}
				.infoBox {
										padding: 20px 0 0 20px;
										width: 49%;
										position: relative;
										float: left;
										height: 100%;
										.name {
												border: 1px solid #ddd;
												padding: 10px;
												color: #333;
												background: none;
												font-weight: 600;
												width: calc(100% - 0px);
												font-size: 18px;
												line-height: 30px;
												position: relative;
											}
					.name::after {
												left: 0;
												background: #f7db61;
												bottom: 0;
												width: 0px;
												position: absolute;
												content: "";
												transition: all 0.5s ease;
												height: 0px;
											}
					.desc {
												padding: 0 10px 0 0;
												margin: 30px 0 0;
												overflow: hidden;
												color: #666;
												text-indent: 2em;
												font-size: 15px;
												line-height: 30px;
												height: 60px;
											}
					.infoCenter {
												padding: 20px 0;
												margin: 0px 0 0;
												display: flex;
												width: 100%;
												justify-content: flex-end;
												flex-wrap: wrap;
												.publisher_item {
														padding: 0 10px 0 0;
														.icon {
																margin: 0 2px 0 0;
																display: none;
																line-height: 1.5;
															}
							.label {
																line-height: 1.5;
															}
							.text {
																line-height: 1.5;
															}
						}
						.like_item {
														padding: 0 10px 0 0;
														.icon {
																margin: 0 2px 0 0;
																display: none;
																line-height: 1.5;
															}
							.label {
																line-height: 1.5;
															}
							.text {
																line-height: 1.5;
															}
						}
						.collect_item {
														padding: 0 10px 0 0;
														.icon {
																margin: 0 2px 0 0;
																display: none;
																line-height: 1.5;
															}
							.label {
																line-height: 1.5;
															}
							.text {
																line-height: 1.5;
															}
						}
						.view_item {
														padding: 0 10px 0 0;
														.icon {
																margin: 0 2px 0 0;
																display: none;
																line-height: 1.5;
															}
							.label {
																line-height: 1.5;
															}
							.text {
																line-height: 1.5;
															}
						}
					}
					.infoBottom {
												margin: 10px 0 0;
												display: flex;
												justify-content: space-between;
												align-items: center;
												flex-wrap: wrap;
												.time_item {
														border: 1px solid #ddd;
														padding: 10px;
														.icon {
																margin: 0 2px 0 0;
																line-height: 1.5;
															}
							.label {
																line-height: 1.5;
															}
							.text {
																line-height: 1.5;
															}
						}
						.more_btn {
														border: 1px solid #ddd;
														border-radius: 0px;
														padding: 10px;
														background: none;
														display: block;
														width: 150px;
														line-height: 1.5;
														text-align: center;
														.text {
																color: inherit;
															}
							.icon {
																color: inherit;
																display: none;
															}
						}
					}
				}
			}
			.list-item2:hover {
								cursor: pointer;
								background: #1b4955;
								.img {
					img {
												transform: scale(1.05);
											}
				}
				.infoBox {
										.name {
												border: 0px solid #ffffff50;
												color: #fff;
												background: none;
											}
					.name::after {
												width: 0px;
											}
					.desc {
												color: #fff;
											}
					.infoCenter {
						.publisher_item {
							.icon {
																color: #fff;
															}
							.label {
																color: #fff;
															}
							.text {
																color: #fff;
															}
						}
						.like_item {
							.icon {
																color: #fff;
															}
							.label {
																color: #fff;
															}
							.text {
																color: #fff;
															}
						}
						.collect_item {
							.icon {
																color: #fff;
															}
							.label {
																color: #fff;
															}
							.text {
																color: #fff;
															}
						}
						.view_item {
							.icon {
																color: #fff;
															}
							.label {
																color: #fff;
															}
							.text {
																color: #fff;
															}
						}
					}
					.infoBottom {
						.time_item {
							.icon {
																color: #fff;
															}
							.label {
																color: #fff;
															}
							.text {
																color: #fff;
															}
						}
						.more_btn {
														background: #ffffff30;
														.text {
																color: #fff;
															}
							.icon {
																color: #666;
															}
						}
					}
				}
			}
		}
		.hot {
						margin: 20px 0 0;
						background: none;
						width: 100%;
						height: auto;
						order: 80;
						.hot-title {
								padding: 0 50px 30px;
								z-index: 999;
								color: #1b4955;
								background: url(http://codegen.caihongy.cn/20241203/0dcbd9e05e1b4ae5966c705ff6dc23b4.png) no-repeat center bottom;
								font-weight: 600;
								width: auto;
								font-size: 32px;
								position: inherit;
								text-align: center;
							}
			.hot-list {
								padding: 0;
								margin: 30px 0 0;
								background: none;
								display: flex;
								width: 100%;
								justify-content: space-between;
								flex-wrap: wrap;
								height: auto;
								.hot-item {
										cursor: pointer;
										border: 1px solid #1b4955;
										border-radius: 30px 30px 0 ;
										padding: 10px;
										margin: 0 0 20px;
										background: #fff;
										width: calc(25% - 20px);
										height: auto;
										img {
												border-radius: 30px;
												object-fit: cover;
												display: block;
												width: 110px;
												float: left;
												height: 110px;
											}
					.hot-name {
												padding: 0px 5px 0;
												overflow: hidden;
												color: #333;
												white-space: nowrap;
												width: calc(100% - 120px);
												font-size: 15px;
												line-height: 24px;
												text-overflow: ellipsis;
												float: right;
											}
					.hot-time {
												padding: 0 5px;
												color: #999;
												display: inline-block;
												width: calc(100% - 120px);
												font-size: 14px;
												line-height: 24px;
												float: right;
												text-align: right;
											}
				}
			}
		}
		.idea1 {
						background: none;
						width: 100%;
						height: 1px;
						order: 10;
					}
	}
	
	.index-pv1 .animation-box {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
		z-index: initial;
	}
	
	.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
	}
	
	.index-pv1 .animation-box img {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
	}
	
	.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(0.98) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
</style>
