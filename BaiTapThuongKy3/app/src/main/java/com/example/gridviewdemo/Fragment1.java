package com.example.gridviewdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class Fragment1 extends Fragment {
    GridView gridView;
    ArrayList<SanPham> arrayList = new ArrayList<SanPham>();
    Bitmap yourBitmap ;
    private ISendDataListener iSendDataListener;
    public interface ISendDataListener {
        public void sendData(String ten, String gia, int hinh, String mota, String xuatxu, String thanhphan, String khuyenmai);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        iSendDataListener = (ISendDataListener) getActivity();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridView = view.findViewById(R.id.gridView_sanPham);
        arrayList.add(new SanPham("Sữa tươi", "30.000đ", R.drawable.suatuoi
                , "Sữa tốt cho chiều cao trẻ em và có sức khỏe tốt", "Việt Nam"
                , "100% sữa bò nguyên chất", "Mua 2 hộp tặng 1 hộp"));
        arrayList.add(new SanPham("Bánh Karo", "32.000đ", R.drawable.banhkaro
                , "Với công nghệ tiên phong cho ra đời chiếc bánh đậm đà – thơm hương trứng, đậm vị chà bông thật hấp dẫn. Bánh mềm xốp, phồng mịn, ruốc đan xen đều khắp bánh.", "Việt Nam"
                , "100% trứng tươi và sợi thịt gà (trong đó có 22% trứng tươi, 21% sợi thịt gà)", "Mua 5 hộp giảm giá 20%"));
        arrayList.add(new SanPham("Sữa Milo", "12.000đ", R.drawable.milo
                , "Sữa Milo là một trong những thương hiệu sữa của Nestle mang hương vị của socola đặc trưng", "Việt Nam"
                , "Sữa, nước PROTOMALT, đường, dầu thực vật, bột cacao, siro glucose, hỗn hợp ngũ cốc, các khoáng chất, chất ổn định 418, chất nhũ hóa 322, các vitamin, chất tạo ngọt tự nhiên, hương vani tổng hợp"
                , "Tặng kèm quyển sổ ghi chép"));
        arrayList.add(new SanPham("Ngũ cốc", "35.000đ", R.drawable.ngucoc
                , "Ngũ cốc dinh dưỡng có hương vị thơm ngon độc đáo và bổ dưỡng, là món ăn bổ dưỡng phù hợp với mọi lứa tuổi, tiện sử dụng làm bữa điểm tâm ở mọi nơi, mọi thời điểm trong ngày.", "Việt Nam"
                , "Bột ngũ cốc(Lúa mạch, lúa mì, gạo, bắp, đậu nành, chiết xuất malt), Đường, Bột kem không sữa, Sữ bột nguyên kem, Muối canxi, Chất chống đông vòn(E551)"
                , "Mua 2 bịch tặng kèm ly thủy tinh"));
        arrayList.add(new SanPham("Sữa Ovaltine", "30.000đ", R.drawable.ovaltine
                , "Sữa tốt cho chiều cao trẻ em và có sức khỏe tốt", "Việt Nam"
                , "Nước, đường, chiết xuất lúa mạch 2.1%, sữa bột nguyên kem (sữa bò 2%), sữa bột gầy (sữa bò) 1.3%, bột cacao, bột whey, khoáng chất, kem không sữa, dầu hạt cọ hydro hoá, chất ổn định,..."
                , "Mỗi lốc tặng kèm miếng hình dán"));
        arrayList.add(new SanPham("Coca-cola", "15.000đ", R.drawable.coca
                , "Từ thương hiệu nước giải khát Coca Cola nổi tiếng thế giới được ưa chuộng tại nhiều nhiều quốc gia. 6 chai nước ngọt Coca Cola Zero 390ml cho cơ thể cảm giác nhẹ nhàng, ăn ngon hơn, không đường không calo phù hợp cho những ai yêu thích nước ngọt nhưng vẫn muốn giữ thói quen ăn uống lành mạnh", "Mỹ"
                , "Nước bão hòa CO2, màu tự nhiên, chất điều chỉnh độ acid, chất tạo ngọt tổng hợp, chất bảo quản, hương cola tự nhiên và caffeine."
                , "Mua 1 lốc 6 lon tặng kèm 1 voucher khuyến mãi 20%"));
        arrayList.add(new SanPham("Pepsi", "15.000đ", R.drawable.pepsi
                , "Là loại nước ngọt được nhiều người yêu thích đến từ thương hiệu nổi tiếng thế giới Pepsi với hương vị thơm ngon, sảng khoái. 6 lon nước ngọt Pepsi không calo lon 320ml với lượng gas lớn sẽ giúp bạn xua tan mọi cảm giác mệt mỏi, căng thẳng, sản phẩm không calo lành mạnh, tốt cho sức khỏe", "Mỹ"
                , "Nước bão hoà CO2, chất điều chỉnh độ axit, màu tổng hợp, hỗn hợp hương tự nhiên, chất tạo ngọt tổng hợp, chất bảo quản, caffeine"
                , "Mua 2 tặng 1 lon"));
        arrayList.add(new SanPham("Mirinda", "15.000đ", R.drawable.mirinda
                , "Sản phẩm nước ngọt giải khát từ thương hiệu Mirinda nổi tiếng được nhiều người ưa chuộng. 6 chai nước ngọt Mirinda cam 390ml với hương vị cam đặc trưng, không chỉ giải khát, mà còn bổ sung thêm vitamin C giúp lấy lại năng lượng cho hoạt động hàng ngày. Cam kết chính hãng và an toàn", "Việt Nam"
                , "Nước bão hòa CO2, đường mía, chất điều chỉnh độ acid(330, 331ii), tinh bột biến tính, chất bảo quản(211), chất nhũ hóa(445iii), hương cam tự nhiên, màu tổng hợp(110)"
                , "Mua 2 tặng 1 lon"));
        int colWidth = gridView.getColumnWidth();
        ArrayAdapter<SanPham> adapter = new MyArrayAdapter((Activity) getContext(), R.layout.gridview_custom, arrayList, colWidth);
        gridView.setAdapter(adapter);
        sendDataToFragment2();
    }

    public void sendDataToFragment2() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String ten = arrayList.get(i).getTen();
                String gia = arrayList.get(i).getGia();
                int hinh = arrayList.get(i).getHinh();
                String mota = arrayList.get(i).getMota();
                String xuatxu = arrayList.get(i).getXuatxu();
                String thanhphan = arrayList.get(i).getThanhphan();
                String khuyenmai = arrayList.get(i).getKhuyenmai();
                iSendDataListener.sendData(ten, gia, hinh, mota, xuatxu, thanhphan, khuyenmai);
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false);
    }
}