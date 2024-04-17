package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hxz
 * 体验正则表达式
 */
public class regexp01 {
    public static void main(String[] args) {
        String content1 = "Dys迎来结局笑笑脑梗加重必须手术！解说LPL已成绝唱。";
        String content2 = "钟爱丝袜的美女们流量不会太差，今天和大家分享的是来自意大利博洛尼亚" +
                "的网红御姐——Eva Level，性感火辣的身材，尤其是大长腿经常以各色丝袜示人，是个名副" +
                "其实的时尚宠儿。";
        String content3 = "    最近，游戏圈“里届”好像异常活跃。\n" +
                "   今年2月，被不少中国玩家称为“里番启蒙之作”的《夜勤病栋》（没错，比良坂龙二的名句就出自这里），" +
                "由DMM GAMES旗下新品牌RG REMAKE完成重制并正式发售（名曰“25周年重制”），且原画出自能唤起大家" +
                "肌肉记忆的知名暗黑系Galgame画师上田メタヲ。\n" +
                "   3月23日，发行于2000年的经典黄油《无颜之月》时隔24年宣布进行重制，重制版的名字也定了：" +
                "《无颜之月：待宵的双椿》。\n" +
                "   其实翻开过往几年视觉小说/文字AVG游戏重制计划表，你会发现有此打算的作品不在少数。\n" +
                "   2022年2月，上世纪90年代的“泰山北斗级”绅士名作《同级生》首次以重制版形式亮相，光Steam平台" +
                "就获得了近1500个评论；两年后，重制版开发商FANZA 旗下品牌FG REMAK又宣布，其续作《同级生2Remake》" +
                "也将于今年6月发售（值得一提的是，《同级生》系列的缔造者ELF，恰恰与《夜勤病栋》开发商Mink会社系出同源）。\n" +
                "   几乎是在同一时期，TYPE-MOON也陆续开启了《魔法使之夜》《月姬》等经典旧作的重制工作；其中已登陆" +
                "NS、PS、PC等平台的《魔法使之夜》高清重制版口碑爆棚，该作在Steam平台更是收获了“好评如潮”（评论数超2100个）。\n" +
                "   热衷于90年代、00年代经典游戏重制的厂商仅仅是做黄油、视觉小说的日本会社吗？非也。纵观近些年海外游企动作，" +
                "乐于“新瓶装旧酒”的厂商只多不少。\n" +
                "   重制营生的佼佼者、“炒冷饭小王子”卡普空靠一手RE引擎混得风生水起，《生化危机》系列重制版不仅赚得盆满钵满，更因《RE2》《RE4》卓越的重制表现，" +
                "实现口碑销量双丰收。鉴于重制游戏的巨大成功，《RE4》总监安保康弘在「PlayStation Partner Awards 2023」" +
                "颁奖典礼后的采访中明确表示，今后还会推出更多的《生化危机》系列重制作品。\n" +
                "   SE更是将上世纪90年代的RPG杰作《最终幻想7》拆分成工程浩大、开发周期逾十年的重制版三部曲，" +
                "而且在套上开放世界框架、裹上更精致的美术包装、梳理出更丰满的主线支线剧情、加入各种精致小游戏之后，" +
                "将重制版做得量大管饱。";

        //1. 先创建一个 Pattern 对象 ， 模式对象, 可以理解成就是一个正则表达式对象
        Pattern pattern1 = Pattern.compile("[a-zA-Z]+");
        Pattern pattern2 = Pattern.compile("[0-9]+");
        Pattern pattern3 = Pattern.compile("([0-9]+)|([a-zA-Z]+)");
        Pattern pattern4 = Pattern.compile("<a target=\"_blank\" title=\"(\\S*)\"");

        //2、创建一个匹配器对象
        Matcher matcher = pattern3.matcher(content3);

        //3、可以开始循环匹配
        while (matcher.find()){
            System.out.println("找到："+ matcher.group(0));
        }
    }
}
