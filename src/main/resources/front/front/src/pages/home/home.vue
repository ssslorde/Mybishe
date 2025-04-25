<template>
	<div class="home-preview">



		<!-- 关于我们 -->
		<div id="about" class="animate__animated">
			<div class="about_item">
				<div class="about_title_box">
					<div class="about_title">{{aboutUsDetail.title}}</div>
					<div class="about_subtitle">{{aboutUsDetail.subtitle}}</div>
				</div>
				<div class="about_img">
					<img :src="baseUrl + aboutUsDetail.picture1">
					<img :src="baseUrl + aboutUsDetail.picture2">
					<img :src="baseUrl + aboutUsDetail.picture3">
				</div>
				<div class="about_content ql-snow ql-editor" v-html="aboutUsDetail.content"></div>
				<div class="about_idea1" />
				<div class="about_idea2" />
				<div class="about_idea3" />
				<div class="about_idea4" />
				<div class="about_more" @click="toDetail('aboutusDetail',aboutUsDetail)">
					<span>查看更多</span>
					<span class="icon iconfont icon-jiantou25"></span>
				</div>
			</div>
		</div>
		<!-- 关于我们 -->

		<!-- 系统简介 -->
		<div id="system" class="animate__animated">
			<div class="system_item">
				<div class="system_title_box">
					<div class="system_title">{{systemIntroductionDetail.title}}</div>
					<div class="system_subtitle">{{systemIntroductionDetail.subtitle}}</div>
				</div>
				<div class="system_img">
					<img :src="baseUrl + systemIntroductionDetail.picture1">
					<img :src="baseUrl + systemIntroductionDetail.picture2">
					<img :src="baseUrl + systemIntroductionDetail.picture3">
				</div>
				<div class="system_content ql-snow ql-editor" v-html="systemIntroductionDetail.content"></div>
				<div class="system_idea1" />
				<div class="system_idea2" />
				<div class="system_idea3" />
				<div class="system_idea4" />
				<div class="system_more" @click="toDetail('systemintroDetail',systemIntroductionDetail)">
					<span>查看更多</span>
					<span class="icon iconfont "></span>
				</div>
			</div>
		</div>
		<!-- 系统简介 -->
		<!-- 新闻资讯 -->
		<div id="animate_newsnews" class="news animate__animated">
			<div class="news_title_box">
				<span class="news_title">公告信息</span>
				<span class="news_subhead">{{'news'.toUpperCase()}}</span>
			</div>
			<!-- 样式五 -->
			<div v-if="newsList.length" class="list list5 index-pv1">
				<div @click="toDetail('newsDetail', newsList[0])" v-if="newsList.length>0" class="list-item animation-box">
					<img :src="baseUrl + newsList[0].picture" alt="">
					<div class="infoBox">
						<div class="name line1">{{newsList[0].title}}</div>
						<div class="desc line3">{{newsList[0].introduction}}</div>
						<div class="time_item">
							<span class="icon iconfont icon-shijian21"></span>
							<span class="label">发布时间：</span>
							<span class="text">{{newsList[0].addtime.split(' ')[0]}}</span>
						</div>
						<div class="publisher_item">
							<span class="icon iconfont icon-geren16"></span>
							<span class="label">发布人：</span>
							<span class="text">{{newsList[0].name}}</span>
						</div>
						<div class="like_item">
							<span class="icon iconfont icon-zan10"></span>
							<span class="label">点赞：</span>
							<span class="text">{{newsList[0].thumbsupnum}}</span>
						</div>
						<div class="collect_item">
							<span class="icon iconfont icon-shoucang10"></span>
							<span class="label">收藏：</span>
							<span class="text">{{newsList[0].storeupnum}}</span>
						</div>
						<div class="view_item">
							<span class="icon iconfont icon-chakan2"></span>
							<span class="label">浏览次数：</span>
							<span class="text">{{newsList[0].clicknum}}</span>
						</div>
					</div>
				</div>
				<div class="list-body">
					<div @click="toDetail('newsDetail', newsList[1])" v-if="newsList.length>1" class="list-item1 animation-box">
						<div class="name line1">{{newsList[1].title}}</div>
						<div class="desc line3">{{newsList[1].introduction}}</div>
						<div class="time_item">
							<span class="icon iconfont icon-shijian21"></span>
							<span class="label">发布时间：</span>
							<span class="text">{{newsList[1].addtime.split(' ')[0]}}</span>
						</div>
						<div class="publisher_item">
							<span class="icon iconfont icon-geren16"></span>
							<span class="label">发布人：</span>
							<span class="text">{{newsList[1].name}}</span>
						</div>
						<div class="like_item">
							<span class="icon iconfont icon-zan10"></span>
							<span class="label">点赞：</span>
							<span class="text">{{newsList[1].thumbsupnum}}</span>
						</div>
						<div class="collect_item">
							<span class="icon iconfont icon-shoucang10"></span>
							<span class="label">收藏：</span>
							<span class="text">{{newsList[1].storeupnum}}</span>
						</div>
						<div class="view_item">
							<span class="icon iconfont icon-chakan2"></span>
							<span class="label">浏览次数：</span>
							<span class="text">{{newsList[1].clicknum}}</span>
						</div>
					</div>
					<div @click="toDetail('newsDetail', newsList[2])" v-if="newsList.length>2" class="list-item2 animation-box">
						<div class="name line1">{{newsList[2].title}}</div>
						<div class="desc line3">{{newsList[2].introduction}}</div>
						<div class="time_item">
							<span class="icon iconfont icon-shijian21"></span>
							<span class="label">发布时间：</span>
							<span class="text">{{newsList[2].addtime.split(' ')[0]}}</span>
						</div>
						<div class="publisher_item">
							<span class="icon iconfont icon-geren16"></span>
							<span class="label">发布人：</span>
							<span class="text">{{newsList[2].name}}</span>
						</div>
						<div class="like_item">
							<span class="icon iconfont icon-zan10"></span>
							<span class="label">点赞：</span>
							<span class="text">{{newsList[2].thumbsupnum}}</span>
						</div>
						<div class="collect_item">
							<span class="icon iconfont icon-shoucang10"></span>
							<span class="label">收藏：</span>
							<span class="text">{{newsList[2].storeupnum}}</span>
						</div>
						<div class="view_item">
							<span class="icon iconfont icon-chakan2"></span>
							<span class="label">浏览次数：</span>
							<span class="text">{{newsList[2].clicknum}}</span>
						</div>
					</div>
					<div @click="toDetail('newsDetail', newsList[3])" v-if="newsList.length>3" class="list-item3 animation-box">
						<div class="name line1">{{newsList[3].title}}</div>
						<div class="desc line3">{{newsList[3].introduction}}</div>
						<div class="time_item">
							<span class="icon iconfont icon-shijian21"></span>
							<span class="label">发布时间：</span>
							<span class="text">{{newsList[3].addtime.split(' ')[0]}}</span>
						</div>
						<div class="publisher_item">
							<span class="icon iconfont icon-geren16"></span>
							<span class="label">发布人：</span>
							<span class="text">{{newsList[3].name}}</span>
						</div>
						<div class="like_item">
							<span class="icon iconfont icon-zan10"></span>
							<span class="label">点赞：</span>
							<span class="text">{{newsList[3].thumbsupnum}}</span>
						</div>
						<div class="collect_item">
							<span class="icon iconfont icon-shoucang10"></span>
							<span class="label">收藏：</span>
							<span class="text">{{newsList[3].storeupnum}}</span>
						</div>
						<div class="view_item">
							<span class="icon iconfont icon-chakan2"></span>
							<span class="label">浏览次数：</span>
							<span class="text">{{newsList[3].clicknum}}</span>
						</div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('news')">
				<span class="text">查看更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
		</div>
		<!-- 新闻资讯 -->
		<!-- 商品推荐 -->
		<div id="animate_recommendkechengxinxi" class="recommend animate__animated">
			<div class="recommend_title_box">
				<span class="recommend_title">课程信息推荐</span>
				<span class="recommend_subhead">{{'kechengxinxi'.toUpperCase()}} RECOMMEND</span>
			</div>
			<div class="list list22 index-pv1">
				<div class="list-body-left" v-if="kechengxinxiRecommend.length>0">
					<div class="list-item1" @click="toDetail('kechengxinxiDetail', kechengxinxiRecommend[0])">
						<img v-if="preHttp(kechengxinxiRecommend[0].kechengfengmian)" :src="kechengxinxiRecommend[0].kechengfengmian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl + (kechengxinxiRecommend[0].kechengfengmian?kechengxinxiRecommend[0].kechengfengmian.split(',')[0]:'')" alt="" />
						<div class="name">{{kechengxinxiRecommend[0].kechengmingcheng}}</div>
						<div class="name">{{kechengxinxiRecommend[0].kechengleixing}}</div>
						<div class="name">发布时间:{{kechengxinxiRecommend[0].fabushijian}}</div>
					</div>
					<div class="list-item2" v-if="kechengxinxiRecommend.length>1" @click="toDetail('kechengxinxiDetail', kechengxinxiRecommend[1])">
						<div class="img">
							<img v-if="preHttp(kechengxinxiRecommend[1].kechengfengmian)" :src="kechengxinxiRecommend[1].kechengfengmian.split(',')[0]" alt="" />
							<img v-else :src="baseUrl + (kechengxinxiRecommend[1].kechengfengmian?kechengxinxiRecommend[1].kechengfengmian.split(',')[0]:'')" alt="" />
						</div>
						<div class="infoBox">
							<div class="name">{{kechengxinxiRecommend[1].kechengmingcheng}}</div>
							<div class="name">{{kechengxinxiRecommend[1].kechengleixing}}</div>
							<div class="name">发布时间:{{kechengxinxiRecommend[1].fabushijian}}</div>
							<div class="desc ql-snow ql-editor" v-html="kechengxinxiRecommend[1].jiaocaixinxi"></div>

							<div class="bottom" >
								<span class="publisher">{{kechengxinxiRecommend[1].jiaoshizhanghao}}</span>
								<div class="time">{{kechengxinxiRecommend[1].addtime.split(' ')[0]}}</div>
							</div>
							<div class="jian"></div>
					  </div>
					</div>
				</div>
				<div class="list-body-right">
					<div class="list-item1" v-if="kechengxinxiRecommend.length>2" @click="toDetail('kechengxinxiDetail', kechengxinxiRecommend[2])">
						<div class="img">
							<img v-if="preHttp(kechengxinxiRecommend[2].kechengfengmian)" :src="kechengxinxiRecommend[2].kechengfengmian.split(',')[0]" alt="" />
							<img v-else :src="baseUrl + (kechengxinxiRecommend[2].kechengfengmian?kechengxinxiRecommend[2].kechengfengmian.split(',')[0]:'')" alt="" />
						</div>
						<div class="infoBox">
							<div class="name">{{kechengxinxiRecommend[2].kechengmingcheng}}</div>
							<div class="name">{{kechengxinxiRecommend[2].kechengleixing}}</div>
							<div class="name">发布时间:{{kechengxinxiRecommend[2].fabushijian}}</div>
							<div class="desc ql-snow ql-editor" v-html="kechengxinxiRecommend[2].jiaocaixinxi"></div>

							<div class="bottom">
								<span class="publisher">{{kechengxinxiRecommend[2].jiaoshizhanghao}}</span>
								<div class="time">{{kechengxinxiRecommend[2].addtime.split(' ')[0]}}</div>
							</div>
							<div class="jian"></div>
						</div>
					</div>
					<div class="list-item2" v-if="kechengxinxiRecommend.length>3" @click="toDetail('kechengxinxiDetail', kechengxinxiRecommend[3])">
						<div class="infoBox">
							<div class="name">{{kechengxinxiRecommend[3].kechengmingcheng}}</div>
							<div class="name">{{kechengxinxiRecommend[3].kechengleixing}}</div>
							<div class="name">发布时间:{{kechengxinxiRecommend[3].fabushijian}}</div>
							<div class="desc ql-snow ql-editor" v-html="kechengxinxiRecommend[3].jiaocaixinxi"></div>

							<div class="bottom">
								<span class="publisher">{{kechengxinxiRecommend[3].jiaoshizhanghao}}</span>
								<div class="time">{{kechengxinxiRecommend[3].addtime.split(' ')[0]}}</div>
							</div>
							<div class="jian"></div>
						</div>
						<div class="img">
							<img v-if="preHttp(kechengxinxiRecommend[3].kechengfengmian)" :src="kechengxinxiRecommend[3].kechengfengmian.split(',')[0]" alt="" />
							<img v-else :src="baseUrl + (kechengxinxiRecommend[3].kechengfengmian?kechengxinxiRecommend[3].kechengfengmian.split(',')[0]:'')" alt="" />
						</div>
					</div>
					<div class="list-item3" v-if="kechengxinxiRecommend.length>4" @click="toDetail('kechengxinxiDetail', kechengxinxiRecommend[4])">
						<div class="img">
							<img v-if="preHttp(kechengxinxiRecommend[4].kechengfengmian)" :src="kechengxinxiRecommend[4].kechengfengmian.split(',')[0]" alt="" />
							<img v-else :src="baseUrl + (kechengxinxiRecommend[4].kechengfengmian?kechengxinxiRecommend[4].kechengfengmian.split(',')[0]:'')" alt="" />
						</div>
						<div class="infoBox">
							<div class="name">{{kechengxinxiRecommend[4].kechengmingcheng}}</div>
							<div class="name">{{kechengxinxiRecommend[4].kechengleixing}}</div>
							<div class="name">发布时间:{{kechengxinxiRecommend[4].fabushijian}}</div>
							<div class="desc ql-snow ql-editor" v-html="kechengxinxiRecommend[4].jiaocaixinxi"></div>

							<div class="bottom">
								<span class="publisher">{{kechengxinxiRecommend[4].jiaoshizhanghao}}</span>
								<div class="time">{{kechengxinxiRecommend[4].addtime.split(' ')[0]}}</div>
							</div>
							<div class="jian"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('kechengxinxi')">
				<span class="text">查看更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
		</div>
		<!-- 商品推荐 -->
		<!-- 特价商品 -->
		<div id="animate_listkechengxinxi" class="lists animate__animated">
			<div class="list_title_box">
				<span class="list_title">课程信息展示</span>
				<span class="list_subhead">{{'kechengxinxi'.toUpperCase()}} SHOW</span>
			</div>
			<!-- 样式四 -->
			<div class="list list4 index-pv1">
				<div v-if="kechengxinxiList.length>0" class="list-item animation-box" @click="toDetail('kechengxinxiDetail', kechengxinxiList[0])">
					<img v-if="preHttp(kechengxinxiList[0].kechengfengmian)" :src="kechengxinxiList[0].kechengfengmian.split(',')[0]" alt="" />
					<img v-else :src="baseUrl + (kechengxinxiList[0].kechengfengmian?kechengxinxiList[0].kechengfengmian.split(',')[0]:'')" alt="" />
					<div class="infoBox">
						<div class="name">{{kechengxinxiList[0].kechengmingcheng}}</div>
						<div class="name">{{kechengxinxiList[0].kechengleixing}}</div>
						<div class="name">发布时间:{{kechengxinxiList[0].fabushijian}}</div>
						<div class="time_item">
							<span class="icon iconfont icon-shijian21"></span>
							<span class="label">发布时间：</span>
							<span class="text">{{kechengxinxiList[0].addtime.split(' ')[0]}}</span>
						</div>
						<div class="publisher_item">
							<span class="icon iconfont icon-geren16"></span>
							<span class="label">发布人：</span>
							<span class="text">{{kechengxinxiList[0].jiaoshizhanghao}}</span>
						</div>
						<div class="like_item">
							<span class="icon iconfont icon-zan10"></span>
							<span class="label">点赞：</span>
							<span class="text">{{kechengxinxiList[0].thumbsupnum}}</span>
						</div>
						<div class="collect_item">
							<span class="icon iconfont icon-shoucang10"></span>
							<span class="label">收藏：</span>
							<span class="text">{{kechengxinxiList[0].storeupnum}}</span>
						</div>
						<div class="view_item">
							<span class="icon iconfont icon-chakan9"></span>
							<span class="label">浏览次数：</span>
							<span class="text">{{kechengxinxiList[0].clicknum}}</span>
						</div>
					</div>
				</div>
				<div class="list-body1">
					<div v-if="kechengxinxiList.length>1" @click="toDetail('kechengxinxiDetail', kechengxinxiList[1])" class="list-item1 animation-box">
						<img v-if="preHttp(kechengxinxiList[1].kechengfengmian)" :src="kechengxinxiList[1].kechengfengmian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl + (kechengxinxiList[1].kechengfengmian?kechengxinxiList[1].kechengfengmian.split(',')[0]:'')" alt="" />
						<div class="infoBox">
							<div class="name">{{kechengxinxiList[1].kechengmingcheng}}</div>
							<div class="name">{{kechengxinxiList[1].kechengleixing}}</div>
							<div class="name">发布时间:{{kechengxinxiList[1].fabushijian}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{kechengxinxiList[1].addtime.split(' ')[0]}}</span>
							</div>
							<div class="publisher_item">
								<span class="icon iconfont icon-geren16"></span>
								<span class="label">发布人：</span>
								<span class="text">{{kechengxinxiList[1].jiaoshizhanghao}}</span>
							</div>
							<div class="like_item">
								<span class="icon iconfont icon-zan10"></span>
								<span class="label">点赞：</span>
								<span class="text">{{kechengxinxiList[1].thumbsupnum}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏：</span>
								<span class="text">{{kechengxinxiList[1].storeupnum}}</span>
							</div>
							<div class="view_item">
								<span class="icon iconfont icon-chakan9"></span>
								<span class="label">浏览次数：</span>
								<span class="text">{{kechengxinxiList[1].clicknum}}</span>
							</div>
						</div>
					</div>
					<div v-if="kechengxinxiList.length>2" @click="toDetail('kechengxinxiDetail', kechengxinxiList[2])" class="list-item2 animation-box">
						<img v-if="preHttp(kechengxinxiList[2].kechengfengmian)" :src="kechengxinxiList[2].kechengfengmian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl + (kechengxinxiList[2].kechengfengmian?kechengxinxiList[2].kechengfengmian.split(',')[0]:'')" alt="" />
						<div class="infoBox">
							<div class="name">{{kechengxinxiList[2].kechengmingcheng}}</div>
							<div class="name">{{kechengxinxiList[2].kechengleixing}}</div>
							<div class="name">发布时间:{{kechengxinxiList[2].fabushijian}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{kechengxinxiList[2].addtime.split(' ')[0]}}</span>
							</div>
							<div class="publisher_item">
								<span class="icon iconfont icon-geren16"></span>
								<span class="label">发布人：</span>
								<span class="text">{{kechengxinxiList[2].jiaoshizhanghao}}</span>
							</div>
							<div class="like_item">
								<span class="icon iconfont icon-zan10"></span>
								<span class="label">点赞：</span>
								<span class="text">{{kechengxinxiList[2].thumbsupnum}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏：</span>
								<span class="text">{{kechengxinxiList[2].storeupnum}}</span>
							</div>
							<div class="view_item">
								<span class="icon iconfont icon-chakan9"></span>
								<span class="label">浏览次数：</span>
								<span class="text">{{kechengxinxiList[2].clicknum}}</span>
							</div>
						</div>
					</div>
				</div>
				<div class="list-body2">
					<div v-if="kechengxinxiList.length>3" @click="toDetail('kechengxinxiDetail', kechengxinxiList[3])" class="list-item1 animation-box">
						<img v-if="preHttp(kechengxinxiList[3].kechengfengmian)" :src="kechengxinxiList[3].kechengfengmian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl + (kechengxinxiList[3].kechengfengmian?kechengxinxiList[3].kechengfengmian.split(',')[0]:'')" alt="" />
						<div class="infoBox">
							<div class="name">{{kechengxinxiList[3].kechengmingcheng}}</div>
							<div class="name">{{kechengxinxiList[3].kechengleixing}}</div>
							<div class="name">发布时间:{{kechengxinxiList[3].fabushijian}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{kechengxinxiList[3].addtime.split(' ')[0]}}</span>
							</div>
							<div class="publisher_item">
								<span class="icon iconfont icon-geren16"></span>
								<span class="label">发布人：</span>
								<span class="text">{{kechengxinxiList[3].jiaoshizhanghao}}</span>
							</div>
							<div class="like_item">
								<span class="icon iconfont icon-zan10"></span>
								<span class="label">点赞：</span>
								<span class="text">{{kechengxinxiList[3].thumbsupnum}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏：</span>
								<span class="text">{{kechengxinxiList[3].storeupnum}}</span>
							</div>
							<div class="view_item">
								<span class="icon iconfont icon-chakan9"></span>
								<span class="label">浏览次数：</span>
								<span class="text">{{kechengxinxiList[3].clicknum}}</span>
							</div>
						</div>
					</div>
					<div v-if="kechengxinxiList.length>4" @click="toDetail('kechengxinxiDetail', kechengxinxiList[4])" class="list-item2 animation-box">
						<img v-if="preHttp(kechengxinxiList[4].kechengfengmian)" :src="kechengxinxiList[4].kechengfengmian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl + (kechengxinxiList[4].kechengfengmian?kechengxinxiList[4].kechengfengmian.split(',')[0]:'')" alt="" />
						<div class="infoBox">
							<div class="name">{{kechengxinxiList[4].kechengmingcheng}}</div>
							<div class="name">{{kechengxinxiList[4].kechengleixing}}</div>
							<div class="name">发布时间:{{kechengxinxiList[4].fabushijian}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{kechengxinxiList[4].addtime.split(' ')[0]}}</span>
							</div>
							<div class="publisher_item">
								<span class="icon iconfont icon-geren16"></span>
								<span class="label">发布人：</span>
								<span class="text">{{kechengxinxiList[4].jiaoshizhanghao}}</span>
							</div>
							<div class="like_item">
								<span class="icon iconfont icon-zan10"></span>
								<span class="label">点赞：</span>
								<span class="text">{{kechengxinxiList[4].thumbsupnum}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏：</span>
								<span class="text">{{kechengxinxiList[4].storeupnum}}</span>
							</div>
							<div class="view_item">
								<span class="icon iconfont icon-chakan9"></span>
								<span class="label">浏览次数：</span>
								<span class="text">{{kechengxinxiList[4].clicknum}}</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('kechengxinxi')">
				<span class="text">查看更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
	

		</div>
		<!-- 特价商品 -->
	</div>
</template>

<script>
import 'animate.css'
import Swiper from "swiper";

	export default {
		//数据集合
		data() {
			return {
				baseUrl: '',
				aboutUsDetail: {},
				systemIntroductionDetail: {},
				newsList: [],
				kechengxinxiRecommend: [],

				kechengxinxiList: [],




			}
		},
		created() {
			this.baseUrl = this.$config.baseUrl;
			this.getNewsList();
			this.getAboutUs();
			this.getSystemIntroduction();
			this.getList();
		},
		mounted() {
			window.addEventListener('scroll', this.handleScroll)
			setTimeout(()=>{
				this.handleScroll()
			},100)
			
			this.swiperChanges()
		},
		beforeDestroy() {
			window.removeEventListener('scroll', this.handleScroll)
		},
		//方法集合
		methods: {
			swiperChanges() {
				setTimeout(()=>{
				},750)
			},


			handleScroll() {
				let arr = [
					{id:'about',css:'animate__'},
					{id:'system',css:'animate__'},
					{id:'animate_recommendkechengxinxi',css:'animate__'},
					{id:'animate_listkechengxinxi',css:'animate__'},
					{id:'animate_newsnews',css:'animate__'},
				]
			
				for (let i in arr) {
					let doc = document.getElementById(arr[i].id)
					if (doc) {
						let top = doc.offsetTop
						let win_top = window.innerHeight + window.pageYOffset
						// console.log(top,win_top)
						if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
							// console.log(doc)
							doc.classList.add(arr[i].css)
						}
					}
				}
			},
			preHttp(str) {
				return str && str.substr(0,4)=='http';
			},
			getAboutUs() {
				this.$http.get('aboutus/detail/1', {}).then(res => {
					if(res.data.code == 0) {
						this.aboutUsDetail = res.data.data;
					}
				})
			},
			getSystemIntroduction() {
				this.$http.get('systemintro/detail/1', {}).then(res => {
					if(res.data.code == 0) {
						this.systemIntroductionDetail = res.data.data;
					}
				})
			},
			getNewsList() {
				let data = {
					page: 1,
					limit: 4,
					sort: 'addtime',
					order: 'desc'
				}
				this.$http.get('news/list', {params: data}).then(res => {
					if (res.data.code == 0) {
						this.newsList = res.data.data.list;
					
					}
				});
			},
			getList() {
				let autoSortUrl = "";
				let data = {}
				autoSortUrl = "kechengxinxi/autoSort";
				if(localStorage.getItem('frontToken')) {
					autoSortUrl = "kechengxinxi/autoSort2";
				}
				data = {
					page: 1,
					limit: 5,
				}
				this.$http.get(autoSortUrl, {params: data}).then(res => {
					if (res.data.code == 0) {
						this.kechengxinxiRecommend = res.data.data.list;
					}
				});
			
				data = {
					page: 1,
					limit: 5,
				}

				this.$http.get('kechengxinxi/list', {params: data}).then(res => {
					if (res.data.code == 0) {
						this.kechengxinxiList = res.data.data.list;
					}
				});
			},
			toDetail(path, item) {
				this.$router.push({path: '/index/' + path, query: {id: item.id}});
			},
			moreBtn(path) {
				this.$router.push({path: '/index/' + path});
			}
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
		margin: 0px auto;
		flex-direction: column;
		background: #fff;
		display: flex;
		width: 100%;
		#about {
			padding: 50px 0 50px;
			margin: 0;
			background: url(http://codegen.caihongy.cn/20241203/e55a8058a4ee4e76bbfd85ce46c5404e.jpg) no-repeat center top / 100% 100%;
			width: 100%;
			height: auto;
			order: 3;
			.about_item {
				padding: 0;
				margin: 0px auto;
				z-index: 9;
				overflow: hidden;
				background: url(http://codegen.caihongy.cn/20241203/95a6a9e2cd5347e5ac6ce520c9cb6880.png) no-repeat left 120px;
				display: block;
				width: 1200px;
				position: relative;
				flex-wrap: wrap;
				height: 650px;
				.about_title_box {
					padding: 0 0 20px;
					margin: 0 0 60px;
					background: none;
					display: flex;
					width: 100%;
					justify-content: center;
					position: relative;
					text-align: left;
					.about_title {
						padding: 0 50px 30px;
						z-index: 999;
						color: #fff;
						background: url(http://codegen.caihongy.cn/20241203/f65ed445ed0a45dd9041b567bb8b97f6.png) no-repeat center bottom;
						font-weight: 600;
						width: auto;
						font-size: 32px;
						position: inherit;
					}
					.about_subtitle {
						margin: 0;
						color: #999;
						display: none;
						width: auto;
						font-size: 18px;
						line-height: 40px;
						text-align: center;
					}
				}
				.about_img {
					padding: 0;
					margin: 0;
					top: 170px;
					left: 50px;
					background: none;
					display: flex;
					width: 410px;
					position: absolute;
					flex-wrap: wrap;
					height: 410px;
					img:nth-child(1) {
						border-radius: 100%;
						margin: 0;
						object-fit: cover;
						display: block;
						width: 100%;
						height: 100%;
					}
					img:nth-child(2) {
						margin: 0 10px;
						flex: 1;
						object-fit: cover;
						display: none;
						height: 120px;
					}
					img:nth-child(3) {
						margin: 0 10px;
						flex: 1;
						object-fit: cover;
						display: none;
						height: 120px;
					}
				}
				.about_content {
					padding: 30px;
					margin: 0px 0 0;
					overflow: hidden;
					color: #fff;
					background: none;
					width: 55%;
					font-size: 16px;
					line-height: 30px;
					float: right;
					height: 360px;
				}
				.about_idea1 {
					z-index: -1;
					top: 0;
					background: #d10602;
					display: none;
					width: 100%;
					position: absolute;
					right: 0;
					height: 400px;
				}
				.about_idea2 {
					background: url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat;
					display: none;
					width: 285px;
					height: 100px;
				}
				.about_idea3 {
					background: url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat;
					display: none;
					width: 285px;
					height: 100px;
				}
				.about_idea4 {
					background: url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat;
					display: none;
					width: 285px;
					height: 100px;
				}
				.about_more {
					border: 1px solid #ccc;
					padding: 0 20px 0 0;
					margin: 0;
					z-index: 999;
					bottom: 60px;
					display: block;
					line-height: 48px;
					border-radius: 50px;
					left: 47.5%;
					background: url(http://codegen.caihongy.cn/20241203/45fb9c49bbe64cc494d7796030bafbcb.png) no-repeat 85% center / 20px,#fff;
					width: 150px;
					position: absolute;
					text-align: center;
					span:nth-child(1) {
						color: #999;
						font-size: 15px;
					}
					span:nth-child(2) {
						color: #333;
						display: none;
						font-size: 15px;
					}
				}
				.about_more:hover {
					cursor: pointer;
					opacity: 1;
				}
			}
		}
		#system {
			padding: 60px 0;
			margin: 0;
			background: #fff;
			width: 100%;
			height: auto;
			order: 1;
			.system_item {
				margin: 0 auto;
				display: block;
				width: 1200px;
				position: relative;
				flex-wrap: wrap;
				height: 480px;
				.system_title_box {
					padding: 0;
					margin: 0;
					top: 0;
					left: 0px;
					background: none;
					width: 100%;
					position: absolute;
					text-align: left;
					height: 40px;
					.system_title {
						padding: 0 50px 30px;
						z-index: 999;
						color: #1b4955;
						background: url(http://codegen.caihongy.cn/20241203/0dcbd9e05e1b4ae5966c705ff6dc23b4.png) no-repeat center bottom;
						font-weight: 600;
						width: auto;
						font-size: 32px;
						position: inherit;
					}
					.system_subtitle {
						color: #999;
						display: none;
						font-size: 24px;
					}
				}
				.system_img {
					padding: 0;
					margin: 0;
					background: none;
					display: block;
					width: 540px;
					float: right;
					flex-wrap: wrap;
					height: 100%;
					img:nth-child(1) {
						border-radius: 10px 88px 10px 10px;
						object-fit: cover;
						display: block;
						width: 100%;
						height: 480px;
					}
					img:nth-child(2) {
						object-fit: cover;
						display: none;
						width: 100%;
						height: 480px;
					}
					img:nth-child(3) {
						object-fit: cover;
						display: none;
						width: 330px;
						height: 120px;
					}
				}
				.system_content {
					padding: 90px 0 0;
					margin: 0;
					z-index: 99;
					overflow: hidden;
					color: #666;
					background: none;
					width: calc(100% - 580px);
					font-size: 16px;
					line-height: 30px;
					position: inherit;
					height: 420px;
				}
				.system_idea1 {
					padding: 0;
					margin: 0;
					z-index: 0;
					overflow: hidden;
					color: #666;
					background: #fff;
					display: none;
					width: 80px;
					font-size: 16px;
					line-height: 30px;
					height: 80px;
				}
				.system_idea2 {
					background: url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat;
					display: none;
					width: 285px;
					height: 100px;
				}
				.system_idea3 {
					background: url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat;
					display: none;
					width: 285px;
					height: 100px;
				}
				.system_idea4 {
					background: url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat;
					display: none;
					width: 285px;
					height: 100px;
				}
				.system_more {
					border: 1px solid #ccc;
					border-radius: 50px;
					padding: 0 20px 0 0;
					margin: 10px 20px  0 0;
					z-index: 999;
					background: url(http://codegen.caihongy.cn/20241203/45fb9c49bbe64cc494d7796030bafbcb.png) no-repeat 85% center / 20px,#fff;
					display: block;
					width: 150px;
					line-height: 48px;
					position: inherit;
					float: left;
					text-align: center;
					span:nth-child(1) {
						color: #999;
						font-size: 15px;
					}
					span:nth-child(2) {
						color: #999;
						display: none;
						font-size: 15px;
					}
				}
				.system_more:hover {
					cursor: pointer;
					opacity: 1;
				}
			}
		}
		.news {
			padding: 50px 0 30px;
			margin: 0;
			background: #fff;
			width: 100%;
			position: relative;
			text-align: center;
			order: 5;
			.news_title_box {
				padding: 0;
				margin: 0 0 40px;
				background: none;
				display: flex;
				width: 100%;
				justify-content: center;
				position: relative;
				text-align: left;
				.news_title {
					padding: 0 50px 30px;
					z-index: 999;
					color: #1b4955;
					background: url(http://codegen.caihongy.cn/20241203/0dcbd9e05e1b4ae5966c705ff6dc23b4.png) no-repeat center bottom;
					font-weight: 600;
					width: auto;
					font-size: 32px;
					position: inherit;
				}
				.news_subhead {
					margin: 0;
					color: #999;
					display: none;
					width: auto;
					font-size: 18px;
					line-height: 40px;
					text-align: center;
				}
			}
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
			.list5 {
				padding: 0;
				margin: 0 auto;
				color: #888;
				background: none;
				width: 1200px;
				font-size: 14px;
				text-align: left;
				height: auto;
				.list-item {
					cursor: pointer;
					margin: 0 0 30px;
					background: #fff;
					width: 100%;
					height: 275px;
					img {
						object-fit: cover;
						width: 500px;
						float: left;
						height: 275px;
					}
					.infoBox {
						padding: 10px;
						align-content: center;
						background: none;
						display: flex;
						width: calc(100% - 500px);
						align-items: center;
						flex-wrap: wrap;
						height: 275px;
						.name {
							padding: 10px;
							overflow: hidden;
							color: #333;
							white-space: nowrap;
							font-weight: 600;
							width: 100%;
							font-size: 16px;
							line-height: 1.5;
							text-overflow: ellipsis;
						}
						.desc {
							padding: 10px;
							max-height: 150px;
							overflow: hidden;
							color: #666;
							width: 100%;
							font-size: 14px;
							line-height: 30px;
							height: auto;
						}
						.time_item {
							padding: 0 10px;
							margin: 10px 0;
							display: inline-block;
							width: 100%;
							order: 11;
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
						.publisher_item {
							padding: 0 10px;
							display: inline-block;
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
							padding: 0 10px;
							display: inline-block;
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
							padding: 0 10px;
							display: inline-block;
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
							padding: 0 10px;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								display: none;
								line-height: 1.5;
							}
							.label {
								color: #666;
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
					}
				}
				.list-body {
					color: #fff;
					background: #fff;
					display: flex;
					width: 100%;
					justify-content: space-between;
					flex-wrap: wrap;
					height: 275px;
					.list-item1 {
						cursor: pointer;
						padding: 20px 10px 10px 20px;
						align-content: center;
						background: #5d7e86;
						display: flex;
						width: 32%;
						align-items: center;
						position: relative;
						flex-wrap: wrap;
						height: 275px;
						.name {
							padding: 0 10px 0 0;
							overflow: hidden;
							color: #fff;
							white-space: nowrap;
							font-weight: 600;
							width: 100%;
							font-size: 16px;
							line-height: 1.5;
							text-overflow: ellipsis;
						}
						.desc {
							padding: 10px 10px 10px 0;
							overflow: hidden;
							color: #fff;
							width: 100%;
							font-size: 14px;
							line-height: 30px;
							height: 90px;
						}
						.time_item {
							padding: 0 10px 0 0;
							margin: 10px 0;
							display: inline-block;
							order: 11;
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
						.publisher_item {
							padding: 0 10px 0 0;
							display: inline-block;
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
							display: inline-block;
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
							display: inline-block;
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
							display: inline-block;
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
					.list-item2 {
						cursor: pointer;
						padding: 20px 10px 10px 20px;
						align-content: center;
						background: #5d7e86;
						display: flex;
						width: 32%;
						align-items: center;
						position: relative;
						flex-wrap: wrap;
						height: 275px;
						.name {
							padding: 0 10px 0 0;
							overflow: hidden;
							color: #fff;
							white-space: nowrap;
							font-weight: 600;
							width: 100%;
							font-size: 16px;
							line-height: 1.5;
							text-overflow: ellipsis;
						}
						.desc {
							padding: 10px 10px 10px 0;
							overflow: hidden;
							color: #fff;
							width: 100%;
							font-size: 14px;
							line-height: 30px;
							height: 90px;
						}
						.time_item {
							padding: 0 10px 0 0;
							margin: 10px 0;
							display: inline-block;
							order: 11;
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
						.publisher_item {
							padding: 0 10px 0 0;
							display: inline-block;
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
							display: inline-block;
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
							display: inline-block;
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
							display: inline-block;
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
					.list-item3 {
						cursor: pointer;
						padding: 20px 10px 10px 20px;
						align-content: center;
						background: #5d7e86;
						display: flex;
						width: 32%;
						align-items: center;
						position: relative;
						flex-wrap: wrap;
						height: 275px;
						.name {
							padding: 0 10px 0 0;
							overflow: hidden;
							color: #fff;
							white-space: nowrap;
							font-weight: 600;
							width: 100%;
							font-size: 16px;
							line-height: 1.5;
							text-overflow: ellipsis;
						}
						.desc {
							padding: 10px 10px 10px 0;
							overflow: hidden;
							color: #fff;
							width: 100%;
							font-size: 14px;
							line-height: 30px;
							height: 90px;
						}
						.time_item {
							padding: 0 10px 0 0;
							margin: 10px 0;
							display: inline-block;
							width: 100%;
							order: 11;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								display: none;
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
						.publisher_item {
							padding: 0 10px 0 0;
							display: inline-block;
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
							display: inline-block;
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
							display: inline-block;
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
							display: inline-block;
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
				}
			}
			.moreBtn {
				border: 1px solid #ccc;
				cursor: pointer;
				border-radius: 50px;
				padding: 0 20px 0 0;
				margin: 20px auto;
				z-index: 999;
				background: url(http://codegen.caihongy.cn/20241203/45fb9c49bbe64cc494d7796030bafbcb.png) no-repeat 85% center / 20px,#fff;
				display: inline-block;
				width: 150px;
				line-height: 48px;
				position: inherit;
				text-align: center;
				.text {
					color: #999;
					font-size: 15px;
				}
				.icon {
					color: #333;
					display: none;
					font-size: 15px;
				}
			}
		}
		.recommend {
			padding: 30px 0 20px;
			margin: 0;
			background: #f3f6ff;
			width: 100%;
			position: relative;
			text-align: center;
			order: 2;
			.recommend_title_box {
				padding: 0 0 20px;
				margin: 0 0 40px;
				background: none;
				width: 100%;
				position: relative;
				text-align: center;
				.recommend_title {
					padding: 0 50px 30px;
					z-index: 999;
					color: #1b4955;
					background: url(http://codegen.caihongy.cn/20241203/0dcbd9e05e1b4ae5966c705ff6dc23b4.png) no-repeat center bottom;
					font-weight: 600;
					width: auto;
					font-size: 32px;
					position: inherit;
				}
				.recommend_subhead {
					margin: 0;
					color: #999;
					display: none;
					width: auto;
					font-size: 18px;
					line-height: 40px;
					text-align: center;
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
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
			.list22 {
				margin: 0px auto 0;
				overflow: hidden;
				display: flex;
				width: 1200px;
				justify-content: space-between;
				text-align: left;
				.list-body-left {
					width: 49.5%;
					.list-item1 {
						border: 1px solid #eee;
						margin: 0 0 6px;
						overflow: hidden;
						display: block;
						width: 100%;
						position: relative;
						height: 390px;
						img {
							object-fit: cover;
							display: block;
							width: 100%;
							transition: all 0.3s;
							height: 100%;
						}
						.name {
							padding: 0 0 0 20px;
							z-index: 100;
							background-size: 100%;
							color: #fff;
							white-space: nowrap;
							bottom: 0;
							display: none;
							font-size: 15px;
							line-height: 40px;
							text-overflow: ellipsis;
							box-sizing: border-box;
							overflow: hidden;
							left: 0;
							background: rgba(0,0,0,.2);
							width: 100%;
							position: absolute;
							height: 40px;
						}
					}
					.list-item1:hover {
						img {
							cursor: pointer;
							transform: scale(1.05);
						}
						.name {
						}
					}
					.list-item2 {
						cursor: pointer;
						display: flex;
						width: 100%;
						.img {
							border: 10px solid #fff;
							z-index: 50;
							overflow: hidden;
							width: 50%;
							position: relative;
							height: 192px;
							img {
								object-fit: cover;
								display: block;
								width: 100%;
								transition: all 0.3s;
								height: 100%;
							}
						}
						.infoBox {
							padding: 10px 10px 10px 0;
							z-index: 100;
							background: #fff;
							width: 50%;
							position: relative;
							height: 192px;
							.name {
								padding: 0 10px 0 0;
								margin: 0;
								overflow: hidden;
								color: #404040;
								white-space: nowrap;
								font-weight: 900;
								width: 100%;
								font-size: 14px;
								line-height: 24px;
								text-overflow: ellipsis;
								box-sizing: border-box;
								height: 24px;
							}
							.price {
								margin: 5px 0 0;
								color: #d90000;
								width: 100%;
								font-size: 18px;
								border-color: #b7b7b7;
								border-width: 0 0 2px;
								border-style: dotted;
							}
							.desc {
								border: 1px dashed #dadada;
								padding: 5px 10px 0 0;
								margin: 5px 0 0;
								overflow: hidden;
								color: #666;
								display: none;
								font-size: 14px;
								border-width: 1px 0 0;
								line-height: 24px;
								box-sizing: border-box;
								height: 48px;
							}
							.bottom {
								margin: 0;
								overflow: hidden;
								background: none;
								bottom: 5px;
								display: flex;
								width: calc(100% - 20px);
								justify-content: space-between;
								position: absolute;
								.publisher {
									color: #747474;
									width: calc(100% - 110px);
									font-size: 14px;
								}
								.time {
									color: #999;
									display: inline;
									width: 110px;
									font-size: 14px;
									line-height: 28px;
									text-align: right;
									height: 28px;
								}
							}
							.jian {
								margin: -7px 0 0;
								clip-path: polygon(100% 1%, 100% 100%, 0% 50%);
								top: 50%;
								left: -8px;
								background: #fcfcfc;
								display: none;
								width: 9px;
								position: absolute;
								height: 14px;
							}
						}
					}
					.list-item2:hover {
						.img {
							img {
								transform: scale(1.05);
							}
						}
						.infoBox {
							background: #fff;
							.name {
							}
							.price {
							}
							.desc {
							}
							.bottom {
								.publisher {
								}
								.time {
								}
							}
							.jian {
								background: #03cce9;
							}
						}
					}
				}
				.list-body-right {
					width: 49.5%;
					.list-item1 {
						cursor: pointer;
						margin: 0 0 6px;
						display: flex;
						width: 100%;
						.img {
							border: 10px solid #fff;
							z-index: 50;
							overflow: hidden;
							width: 50%;
							position: relative;
							height: 192px;
							img {
								object-fit: cover;
								display: block;
								width: 100%;
								transition: all 0.3s;
								height: 100%;
							}
						}
						.infoBox {
							padding: 10px 10px 10px 0;
							z-index: 100;
							background: #fff;
							width: 50%;
							position: relative;
							height: 192px;
							.name {
								padding: 0 10px 0 0;
								margin: 0;
								overflow: hidden;
								color: #404040;
								white-space: nowrap;
								font-weight: 900;
								width: 100%;
								font-size: 15px;
								line-height: 24px;
								text-overflow: ellipsis;
								box-sizing: border-box;
								height: 24px;
							}
							.price {
								margin: 5px 0 0;
								color: #d90000;
								width: 100%;
								font-size: 18px;
								border-color: #b7b7b7;
								border-width: 0 0 2px;
								border-style: dotted;
							}
							.desc {
								border: 1px dashed #dadada;
								padding: 5px 10px 0 0;
								margin: 5px 0 0;
								overflow: hidden;
								color: #808080;
								display: none;
								font-size: 14px;
								border-width: 1px 0 0;
								line-height: 24px;
								box-sizing: border-box;
								height: 48px;
							}
							.bottom {
								margin: 0;
								overflow: hidden;
								background: none;
								bottom: 5px;
								display: flex;
								width: calc(100% - 20px);
								justify-content: space-between;
								position: absolute;
								.publisher {
									color: #666;
									width: calc(100% - 110px);
									font-size: 14px;
								}
								.time {
									color: #999;
									display: inline;
									width: 110px;
									font-size: 14px;
									line-height: 24px;
									text-align: right;
									height: 24px;
								}
							}
							.jian {
								margin: -7px 0 0;
								clip-path: polygon(100% 1%, 100% 100%, 0% 50%);
								top: 50%;
								left: -8px;
								background: #fcfcfc;
								display: none;
								width: 9px;
								position: absolute;
								height: 14px;
							}
						}
					}
					.list-item1:hover {
						.img {
							img {
								transform: scale(1.05);
							}
						}
						.infoBox {
							.name {
							}
							.price {
							}
							.desc {
							}
							.bottom {
								.publisher {
								}
								.time {
								}
							}
							.jian {
							}
						}
					}
					.list-item2 {
						cursor: pointer;
						margin: 0 0 6px;
						display: flex;
						width: 100%;
						.img {
							border: 10px solid #fff;
							z-index: 50;
							overflow: hidden;
							width: 50%;
							position: relative;
							height: 192px;
							img {
								object-fit: cover;
								display: block;
								width: 100%;
								transition: all 0.3s;
								height: 100%;
							}
						}
						.infoBox {
							padding: 10px 0 10px 10px;
							z-index: 100;
							background: #fff;
							width: 50%;
							position: relative;
							box-sizing: border-box;
							height: 192px;
							.name {
								padding: 0 10px 0 0;
								margin: 0;
								overflow: hidden;
								color: #404040;
								white-space: nowrap;
								font-weight: 900;
								width: 100%;
								font-size: 15px;
								line-height: 24px;
								text-overflow: ellipsis;
								box-sizing: border-box;
								height: 24px;
							}
							.price {
								margin: 5px 0 0;
								color: #d90000;
								width: 100%;
								font-size: 18px;
								border-color: #b7b7b7;
								border-width: 0 0 2px;
								border-style: dotted;
							}
							.desc {
								border: 1px dashed #dadada;
								padding: 5px 10px 0 0;
								margin: 5px 0 0;
								overflow: hidden;
								color: #808080;
								display: none;
								font-size: 14px;
								line-height: 24px;
								box-sizing: border-box;
								height: 48px;
							}
							.bottom {
								margin: 0;
								overflow: hidden;
								background: none;
								bottom: 5px;
								display: flex;
								width: calc(100% - 20px);
								justify-content: space-between;
								position: absolute;
								.publisher {
									color: #666;
									width: calc(100% - 110px);
									font-size: 14px;
								}
								.time {
									color: #999;
									display: inline;
									width: 110px;
									font-size: 14px;
									line-height: 24px;
									text-align: right;
									height: 24px;
								}
							}
							.jian {
								margin: -7px 0 0;
								clip-path: polygon(0% 0%, 100% 50%, 0% 100%);
								top: 50%;
								background: #fcfcfc;
								display: none;
								width: 9px;
								position: absolute;
								right: -9px;
								height: 14px;
							}
						}
					}
					.list-item2:hover {
						.img {
							img {
								transform: scale(1.05);
							}
						}
						.infoBox {
							.name {
							}
							.price {
							}
							.desc {
							}
							.bottom {
								.publisher {
								}
								.time {
								}
							}
							.jian {
							}
						}
					}
					.list-item3 {
						cursor: pointer;
						margin: 0 0 6px;
						display: flex;
						width: 100%;
						.img {
							border: 10px solid #fff;
							z-index: 50;
							overflow: hidden;
							width: 50%;
							position: relative;
							height: 192px;
							img {
								object-fit: cover;
								display: block;
								width: 100%;
								transition: all 0.3s;
								height: 100%;
							}
						}
						.infoBox {
							padding: 5px 10px 0 10px;
							z-index: 100;
							background: #fcfcfc;
							width: 50%;
							position: relative;
							box-sizing: border-box;
							height: 192px;
							.name {
								padding: 0 10px 0 0;
								margin: 0;
								overflow: hidden;
								color: #404040;
								white-space: nowrap;
								font-weight: 900;
								width: 100%;
								font-size: 15px;
								line-height: 24px;
								text-overflow: ellipsis;
								box-sizing: border-box;
								height: 24px;
							}
							.price {
								margin: 5px 0 0;
								color: #d90000;
								width: 100%;
								font-size: 18px;
								border-color: #b7b7b7;
								border-width: 0 0 2px;
								border-style: dotted;
							}
							.desc {
								border: 1px dashed #dadada;
								padding: 5px 10px 0 0;
								margin: 5px 0 0;
								overflow: hidden;
								color: #808080;
								display: none;
								font-size: 14px;
								border-width: 1px 0 0;
								line-height: 24px;
								box-sizing: border-box;
								height: 48px;
							}
							.bottom {
								margin: 0;
								overflow: hidden;
								background: none;
								bottom: 5px;
								display: flex;
								width: calc(100% - 20px);
								justify-content: space-between;
								position: absolute;
								.publisher {
									color: #666;
									width: calc(100% - 110px);
									font-size: 14px;
								}
								.time {
									color: #747474;
									display: inline;
									width: 110px;
									font-size: 14px;
									line-height: 28px;
									text-align: right;
									height: 28px;
								}
							}
							.jian {
								margin: -7px 0 0;
								clip-path: polygon(100% 1%, 100% 100%, 0% 50%);
								top: 50%;
								left: -8px;
								background: #fcfcfc;
								display: none;
								width: 9px;
								position: absolute;
								height: 14px;
							}
						}
					}
					.list-item3:hover {
						.img {
							img {
								transform: scale(1.05);
							}
						}
						.infoBox {
							.name {
							}
							.price {
							}
							.desc {
							}
							.bottom {
								.publisher {
								}
								.time {
								}
							}
							.jian {
								background: #03cce9;
							}
						}
					}
				}
			}
			.moreBtn {
				border: 1px solid #ccc;
				cursor: pointer;
				border-radius: 50px;
				padding: 0 20px 0 0;
				margin: 20px auto;
				z-index: 999;
				background: url(http://codegen.caihongy.cn/20241203/45fb9c49bbe64cc494d7796030bafbcb.png) no-repeat 85% center / 20px,#fff;
				display: inline-block;
				width: 150px;
				line-height: 48px;
				position: inherit;
				text-align: center;
				.text {
					color: #999;
					font-size: 15px;
				}
				.icon {
					color: #999;
					display: none;
					font-size: 15px;
				}
			}
		}
		.lists {
			padding: 50px 0 30px;
			margin: 0;
			background: url(http://codegen.caihongy.cn/20241203/5f686a285b314a98919fd47beaed1606.jpg) fixed  no-repeat center center / cover;
			width: 100%;
			position: relative;
			text-align: center;
			order: 4;
			.list_title_box {
				padding: 0 0 20px;
				margin: 0 0 30px;
				background: none;
				width: 100%;
				position: relative;
				text-align: center;
				.list_title {
					padding: 0 50px 30px;
					z-index: 999;
					color: #1b4955;
					background: url(http://codegen.caihongy.cn/20241203/0dcbd9e05e1b4ae5966c705ff6dc23b4.png) no-repeat center bottom;
					font-weight: 600;
					width: auto;
					font-size: 32px;
					position: inherit;
				}
				.list_subhead {
					margin: 0;
					color: #999;
					background: none;
					display: none;
					width: auto;
					font-size: 18px;
					line-height: 40px;
					text-align: center;
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
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
			.list4 {
				padding: 0;
				margin: 0 auto;
				color: #fff;
				background: none;
				display: flex;
				width: 1200px;
				font-size: 14px;
				flex-wrap: wrap;
				text-align: left;
				height: auto;
				.list-item {
					cursor: pointer;
					margin: 0 0px 0 0;
					width: calc(44% - 0px);
					position: relative;
					float: left;
					height: 600px;
					order: 2;
					img {
						object-fit: cover;
						width: 100%;
						float: left;
						height: 100%;
					}
					.infoBox {
						padding: 10px 0;
						left: 0;
						bottom: 0;
						background: rgba(0,0,0,.3);
						width: 100%;
						position: absolute;
						.name {
							padding: 0 10px;
							overflow: hidden;
							color: #fff;
							white-space: nowrap;
							width: 100%;
							font-size: 14px;
							line-height: 24px;
							text-overflow: ellipsis;
						}
						.price {
							padding: 0 10px;
							color: #ff2424;
							font-size: 16px;
							line-height: 30px;
						}
						.time_item {
							padding: 0 10px;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								color: inherit;
								display: none;
								font-size: inherit;
								line-height: 1.5;
							}
							.label {
								color: inherit;
								font-size: inherit;
								line-height: 1.5;
							}
							.text {
								color: inherit;
								font-size: inherit;
								line-height: 1.5;
							}
						}
						.publisher_item {
							padding: 0 10px;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								color: inherit;
								display: none;
								font-size: inherit;
								line-height: 1.5;
							}
							.label {
								color: inherit;
								font-size: inherit;
								line-height: 1.5;
							}
							.text {
								color: inherit;
								font-size: inherit;
								line-height: 1.5;
							}
						}
						.like_item {
							padding: 0 10px;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								color: inherit;
								display: none;
								font-size: inherit;
								line-height: 1.5;
							}
							.label {
								color: inherit;
								font-size: inherit;
								line-height: 1.5;
							}
							.text {
								color: inherit;
								font-size: inherit;
								line-height: 1.5;
							}
						}
						.collect_item {
							padding: 0 10px;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								color: inherit;
								display: none;
								font-size: inherit;
								line-height: 1.5;
							}
							.label {
								color: inherit;
								font-size: inherit;
								line-height: 1.5;
							}
							.text {
								color: inherit;
								font-size: inherit;
								line-height: 1.5;
							}
						}
						.view_item {
							padding: 0 10px;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								color: inherit;
								display: none;
								font-size: inherit;
								line-height: 1.5;
							}
							.label {
								color: inherit;
								font-size: inherit;
								line-height: 1.5;
							}
							.text {
								color: inherit;
								font-size: inherit;
								line-height: 1.5;
							}
						}
					}
				}
				.list-body1 {
					margin: 0 30px 0 0;
					display: inline-block;
					width: calc(28% - 30px);
					height: auto;
					order: 1;
					.list-item1 {
						cursor: pointer;
						margin: 0 0 20px;
						display: inline-block;
						width: calc(100% - 0px);
						position: relative;
						float: left;
						height: 290px;
						img {
							object-fit: cover;
							width: 100%;
							float: left;
							height: 100%;
						}
						.infoBox {
							padding: 10px 0;
							left: 0;
							bottom: 0;
							background: rgba(0,0,0,.3);
							width: 100%;
							position: absolute;
							.name {
								padding: 0 10px;
								overflow: hidden;
								color: #fff;
								white-space: nowrap;
								width: 100%;
								font-size: 14px;
								line-height: 24px;
								text-overflow: ellipsis;
							}
							.price {
								padding: 0 10px;
								color: #ff2424;
								font-size: 16px;
								line-height: 30px;
							}
							.time_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.publisher_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
						}
					}
					.list-item2 {
						cursor: pointer;
						margin: 0;
						display: inline-block;
						width: calc(100% - 0px);
						position: relative;
						float: left;
						height: 290px;
						img {
							object-fit: cover;
							width: 100%;
							float: left;
							height: 100%;
						}
						.infoBox {
							padding: 10px 0;
							left: 0;
							bottom: 0;
							background: rgba(0,0,0,.3);
							width: 100%;
							position: absolute;
							.name {
								padding: 0 10px;
								overflow: hidden;
								color: #fff;
								white-space: nowrap;
								width: 100%;
								font-size: 14px;
								line-height: 24px;
								text-overflow: ellipsis;
							}
							.price {
								padding: 0 10px;
								color: #ff2424;
								font-size: 16px;
								line-height: 30px;
							}
							.time_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.publisher_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
						}
					}
				}
				.list-body2 {
					margin: 0 0 0 30px;
					display: inline-block;
					width: calc(28% - 30px);
					height: auto;
					order: 3;
					.list-item1 {
						cursor: pointer;
						margin: 0 0 20px 0;
						display: inline-block;
						width: calc(100% - 0px);
						position: relative;
						float: left;
						height: 290px;
						img {
							object-fit: cover;
							width: 100%;
							float: left;
							height: 100%;
						}
						.infoBox {
							padding: 10px 0;
							left: 0;
							bottom: 0;
							background: rgba(0,0,0,.3);
							width: 100%;
							position: absolute;
							.name {
								padding: 0 10px;
								overflow: hidden;
								color: #fff;
								white-space: nowrap;
								width: 100%;
								font-size: 14px;
								line-height: 24px;
								text-overflow: ellipsis;
							}
							.price {
								padding: 0 10px;
								color: #ff2424;
								font-size: 16px;
								line-height: 30px;
							}
							.time_item {
								padding: 0 0 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.publisher_item {
								padding: 0 0 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0 0 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0 0 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0 0 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
						}
					}
					.list-item2 {
						cursor: pointer;
						margin: 0;
						display: inline-block;
						width: calc(100% - 0px);
						position: relative;
						float: left;
						height: 290px;
						img {
							object-fit: cover;
							width: 100%;
							float: left;
							height: 100%;
						}
						.infoBox {
							padding: 10px 0;
							left: 0;
							bottom: 0;
							background: rgba(0,0,0,.3);
							width: 100%;
							position: absolute;
							.name {
								padding: 0 10px;
								overflow: hidden;
								color: #fff;
								white-space: nowrap;
								width: 100%;
								font-size: 14px;
								line-height: 24px;
								text-overflow: ellipsis;
							}
							.price {
								padding: 0 10px;
								color: #ff2424;
								font-size: 16px;
								line-height: 30px;
							}
							.time_item {
								padding: 0 0 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.publisher_item {
								padding: 0 0 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.like_item {
								padding: 0 0 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.collect_item {
								padding: 0 0 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
							.view_item {
								padding: 0 0 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									color: inherit;
									display: none;
									font-size: inherit;
									line-height: 1.5;
								}
								.label {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
								.text {
									color: inherit;
									font-size: inherit;
									line-height: 1.5;
								}
							}
						}
					}
				}
			}
			.moreBtn {
				border: 1px solid #ccc;
				cursor: pointer;
				border-radius: 50px;
				padding: 0 20px 0 0;
				margin: 20px auto;
				z-index: 999;
				background: url(http://codegen.caihongy.cn/20241203/45fb9c49bbe64cc494d7796030bafbcb.png) no-repeat 85% center / 20px,#fff;
				display: inline-block;
				width: 150px;
				line-height: 48px;
				position: inherit;
				text-align: center;
				.text {
					color: #999;
					font-size: 15px;
				}
				.icon {
					color: #333;
					display: none;
					font-size: 15px;
				}
			}
		}
	}
</style>
