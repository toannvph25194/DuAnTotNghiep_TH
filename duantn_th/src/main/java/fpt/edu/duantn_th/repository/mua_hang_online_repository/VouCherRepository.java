package fpt.edu.duantn_th.repository.mua_hang_online_repository;

import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.VouCherOnlineRepon;
import fpt.edu.duantn_th.entity.VouCher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface VouCherRepository extends JpaRepository<VouCher, UUID> {

    @Query(value = "SELECT Id,MaVouCher,TenVouCher,NgayKetThuc,SoLuongMa,SoLuongDung,GiaTriToiThieuHoaDon,GiaTriGiam,HinhThucGiam FROM VOUCHER\n" +
            "WHERE TrangThai = 1 AND SoLuongMa > SoLuongDung",nativeQuery = true)
    List<VouCherOnlineRepon> getALlVouCher();
}
