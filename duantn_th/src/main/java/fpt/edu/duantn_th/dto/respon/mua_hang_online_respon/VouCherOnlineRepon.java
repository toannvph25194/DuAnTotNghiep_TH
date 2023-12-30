package fpt.edu.duantn_th.dto.respon.mua_hang_online_respon;

import java.util.UUID;

public interface VouCherOnlineRepon {
    UUID getId();
    String getMavoucher();
    String getTenvoucher();
    String getNgayketthuc();
    String getSoluongma();
    String getSoluongdung();
    String getGiatritoithieuhoadon();
    String getGiatrigiam();
    Integer getHinhthucgiam();
}
