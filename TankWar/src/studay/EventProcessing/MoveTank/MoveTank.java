package studay.EventProcessing.MoveTank;

/**
 * @author hxz
 * �����Լ�дʱ����������
 * 1���ػ�ʱ����һ��̹�˻��ڣ�Ҫ�������һ��ͼ��Ȼ���ػ�
 * 2���ƶ�ʱ���ӳ٣�  ����������Ϊ EnemyTank û������߳�
 *    �ڽ��� EnemyTank ���ƶ���ȴʱ����⵽�������£��޷���Ӧ
 * 3��������ʵ���˶���˼·�ǣ��ڴ��� start() �� ÿ50ms�ػ�һ�Σ�
 *    50ms�ڼ��⵽�İ�������ꡢ��һϵ�в������������ػ�ÿһ������Ĺ����У�
 *    �����޸ġ�
 *    ��ˣ������̵߳�50ms���߹����еĲ������Ӻ�,���߼�⵽��������Ϊ�ӳٺ����ȡ��
 *    ��ˣ����ڼ����¼���ÿ�μ�⵽�¼����������иı�󣬾�Ҫ����repaint
 * 4���������½��̵߳�����
 *    ���߳�ִ�� run()�����еĴ��룬������-���̼߳���ִ�У���������
 */
public class MoveTank {
    public static void main(String[] args) {
        LoadTankMove loadTankMove = new LoadTankMove();
        loadTankMove.start();
    }
}


