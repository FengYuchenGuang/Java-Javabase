package Projects.hxz.ZeroMoneyPass;

public class Test {
    public static void main(String[] args) {
        MoneyDetail moneyDetail = new MoneyDetail();

        moneyDetail.addDetail(moneyDetail.informationIntegration("asaass",100.2323,"zhehsishijian",600));
        moneyDetail.addDetail(moneyDetail.informationIntegration("as",10,"zhehsishijian",610));
        moneyDetail.addDetail(moneyDetail.informationIntegration("a",3300,"zhehsishijian",3910));

        moneyDetail.showDetail();
    }
}
