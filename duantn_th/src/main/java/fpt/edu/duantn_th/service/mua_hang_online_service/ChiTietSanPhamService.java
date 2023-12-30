package fpt.edu.duantn_th.service.mua_hang_online_service;

import fpt.edu.duantn_th.dto.respon.mua_hang_online_respon.*;

import java.util.List;
import java.util.UUID;

public interface ChiTietSanPhamService {

   // Detail SP
   ChiTietSPRepon detailSP(UUID idsp);

   // getALl sản phẩm mới nhất và 1 ảnh tại trang ctsp
   List<SanPhamRepon> getAllSPNewTaiCTSP();

   // Load tổng số lượng sản phẩm detail
   TongSoLuongSPRepon loadTongSoLuongSP(UUID idsp);

   // Detail size
   List<DetailSizeRepon> detailSize(UUID idsp);

   // Detail mausac
   List<DetailMauSacRepon> detailMauSac(UUID idsp);

   // Tìm kiếm size theo idsp và idmausac
   List<TimKiemSizeRepon> timkiemSize(UUID idsp , UUID idmausac);

   // Tìm kiếm Màu sắc theo idsp và idsize
   List<TimKiemMauSacRepon> timkiemMauSac(UUID idsp , UUID idsize);

   // Tìm kiếm IdCTSP theo idsp và idmausac , idsize
   TimKiemIDCTSPRepon timkiemIdCTSP(UUID idsp , UUID idmausac , UUID idsize);
}
