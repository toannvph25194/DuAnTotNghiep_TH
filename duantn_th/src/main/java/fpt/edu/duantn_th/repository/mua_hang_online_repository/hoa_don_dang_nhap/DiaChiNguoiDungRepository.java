package fpt.edu.duantn_th.repository.mua_hang_online_repository.hoa_don_dang_nhap;

import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.DiaChiNDRepon;
import fpt.edu.duantn_th.entity.DiaChi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DiaChiNguoiDungRepository extends JpaRepository<DiaChi, UUID> {

    @Query(value = "SELECT tk.taikhoan,sodienthoai,dc.id,dc.diachi,dc.tinh,dc.huyen,dc.xa,dc.trangthai\n" +
            "       FROM DiaChi dc JOIN TAIKHOAN tk ON dc.IdTK = tk.Id  where tk.taikhoan = ?", nativeQuery = true)
    List<DiaChiNDRepon> getAllDiaChiND(String taikhoan);
}
