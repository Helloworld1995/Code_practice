package DesighModel.adapter;

/**
 * 适配器：PS4转USB
 */
public class Adpater implements Target {
    private Adpatee adpatee;
    public Adpater(Adpatee adpatee){
        this.adpatee=adpatee;
    }
    @Override
    public void handleReq() {
        adpatee.request();
    }
}
